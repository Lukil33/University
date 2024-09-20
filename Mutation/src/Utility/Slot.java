package Utility;

import Mutation.Combattimento.*;
import Mutation.Magia.*;
import Mutation.Pozioni.*;
import Mutation.*;
import Exception.SlotFull;

import java.util.ArrayList;

public class Slot{
    public final int MAXDIM = 1;
    public ArrayList<Combattimento> combatArray;
    public ArrayList<Magia> magiaArray;
    public ArrayList<Pozioni> pozioArray;
    public ArrayList<Mutation> genericArray;
    Slot(){
        this.combatArray = new ArrayList<>();
        this.magiaArray = new ArrayList<>();
        this.pozioArray = new ArrayList<>();
        this.genericArray = new ArrayList<>();
    }
    void searchInSlot(Mutation m) throws SlotFull{
        if(m.isActive()){
            removeFromSlot(m);
        }else{
            checkSlot(m);
        }
    }
    private void removeFromSlot(Mutation m){
        if(m instanceof Combattimento){
            combatArray.remove(m);
        }else if(m instanceof Magia){
            magiaArray.remove(m);
        }else if(m instanceof Pozioni){
            pozioArray.remove(m);
        }
        genericArray.remove(m);
    }
    private void checkSlot(Mutation m) throws SlotFull{
        if(combatArray.size() < MAXDIM && m instanceof Combattimento){
            combatArray.add((Combattimento) m);
        }else if(magiaArray.size() < MAXDIM && m instanceof Magia ){
            magiaArray.add((Magia) m);
        }else if(pozioArray.size() < MAXDIM && m instanceof Pozioni){
            pozioArray.add((Pozioni) m);
        }else if(genericArray.size() < MAXDIM){
            genericArray.add(m);
        }else{
            throw new SlotFull();
        }
    }
}