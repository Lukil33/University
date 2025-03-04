package InterfacciaUtente;

import Blocchi.Block.NullBlock;
import Blocchi.Error.BlockErrorException;

public class MainView{
    public final Map general_map;
    public final Furnace fornace;
    public final Inventory inventario;
    public MainView(){
        general_map = new Map();
        fornace = new Furnace();
        inventario = new Inventory();
    }
    public void moveIntoFurnaceFromInventory(int index){
        if(index>=0 && index<inventario.inventario.size()){
            try{
                fornace.setInput(inventario.get_smeltable_item(index));
            }catch(BlockErrorException e){
                System.out.println("Il blocco selezionato non è di tipo SmeltableBlock");
            }
        }else{
            System.out.println("Index out of range");
        }
    }
    public void takeInputFromFurnace(){
        if(!(fornace.watchInput() instanceof NullBlock)){
            inventario.add_block(fornace.getInput());
        }else{
            System.out.println("Input is Empty");
        }
    }
    public void moveIntoInventoryFromFurnace(){
        if(!(fornace.watchOutput() instanceof NullBlock)){
            inventario.add_block(fornace.getOutput());
        }else{
            System.out.println("Output is Empty");
        }
    }
    public void pickUpBlock(Coordinate c){
        try{
            inventario.add_block(general_map.gimme_pickable(c));
            general_map.applyGravityToTop(c);
        }catch(BlockErrorException e){
            System.out.println("Il blocco alle coordinate x:"+c.getX()+" Y:"+c.getY()+" non è prendibile");
        }
    }
    public void changeInventoryComparator(){
        inventario.changeComparator();
        inventario.sortInventory();
    }
    public void smelt(){
        if(fornace.isEmpty()){
            System.out.println("La fornace è vuota");
        }else{
            fornace.smelt();
        }
    }
}