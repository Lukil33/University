package Utility;

import Evocazioni.Energie.*;
import Evocazioni.*;
import Exceptions.*;

import java.util.ArrayList;

public class DatiGiocatore {
    private ArrayList<Evocation> evocazioni;
    private ArrayList<Energy> energie;
    void initialize(ArrayList<Evocation> evoc, ArrayList<Energy> ener){
        this.evocazioni = evoc;
        this.energie = ener;
    }
    void removeEnergy(Energy e){
        energie.remove(e);
    }
    void applyDamage(Evocation e) throws GameOver{
        if(e instanceof SupremeEvocation){
            for(int i=getEvocationSize()-1; i>=0; i--){
                applySingleDamage(i, e);
            }
        }else{
            applySingleDamage(0, e);
        }
    }
    private void applySingleDamage(int i, Evocation e) throws GameOver{
        try{
            this.evocazioni.get(i).applyDamage(e);
        }catch(Die d){
            this.evocazioni.remove(i);
            if(this.evocazioni.isEmpty()){
                throw new GameOver();
            }
        }
    }
    int getEvocationSize(){
        return this.evocazioni.size();
    }
    Evocation getEvocation(int i){
        return this.evocazioni.get(i);
    }
    int getEnergySize(){
        return this.energie.size();
    }
    Energy getEnergy(int i){
        return this.energie.get(i);
    }
}
