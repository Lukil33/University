package Utility;

import Mutation.Magia.Magia;

import java.util.ArrayList;
import java.util.List;

public class Geraldo{
    private int livello;
    private int forza;
    private int velocita;
    private int tolleranza;
    private List<Magia> magie;
    Geraldo(){
        initalizeValues();
    }
    private void initalizeValues(){
        this.livello = 0;
        this.forza = 10;
        this.velocita = 10;
        this.tolleranza = 2;
        this.magie = new ArrayList<Magia>();
    }
    public void modifyStrenght(int x){
        this.forza += x;
    }
    public void modifyVelocity(int x){
        this.velocita += x;
    }
    public void modifyTollerance(int x){
        this.tolleranza += x;
    }
    public void modSpell(Magia x){
        if(this.magie.contains(x)){
            this.magie.remove(x);
        }else{
            this.magie.add(x);
        }
    }

    public int getLevel(){return this.livello;}
    public int getStrenght(){return this.forza;}
    public int getVelocity(){return this.velocita;}
    public int getTollerance(){return this.tolleranza;}
    public List<Magia> getSpells(){return this.magie;}
}