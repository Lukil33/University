package InterfacciaUtente;

import Blocchi.Error.BlockErrorException;
import Blocchi.Interfacce.Block;
import Blocchi.Block.Factory;
import Blocchi.Interfacce.SmeltableBlock;
import InterfacciaUtente.Comparator.AlphabeticalBlockComparator;
import InterfacciaUtente.Comparator.BlockComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Inventory{
    public final ArrayList<Block> inventario;
    private int blockNumber;
    private Comparator<Block> comparatore;
    public Inventory(){
        inventario = new ArrayList<>();
        comparatore = new BlockComparator();
    }
    public void display_in_inventory(){
        for(Block e : inventario){
            e.display_in_inventory();
        }
    }
    public void add_block(Block b){
        inventario.add(b);
        setBlockNumber(b);
        sortInventory();
    }
    private boolean isSmeltable(int index){
        return inventario.get(index) instanceof SmeltableBlock;
    }
    public SmeltableBlock get_smeltable_item(int index) throws BlockErrorException{
        if(isSmeltable(index)){
            return (SmeltableBlock)inventario.remove(index);
        }else{
            throw new BlockErrorException();
        }
    }
    private void setBlockNumber(Block b){
        b.setNum(this.blockNumber);
        this.blockNumber++;
    }
    public void sortInventory(){
        inventario.sort(comparatore);
    }
    public void changeComparator(){
        if(comparatore instanceof AlphabeticalBlockComparator){
            comparatore = new BlockComparator();
        }else{
            comparatore = new AlphabeticalBlockComparator();
        }
    }
}