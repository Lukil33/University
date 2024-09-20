package Evocazioni;

import Evocazioni.Energie.Energy;

public class Attack{
    private final String name;
    private final int numEnergie;
    private int energieAttive;
    private Energy tipo;
    private final int numDanni;
    public Attack(String n, int nE, int nD){
        this.name = n;
        this.numEnergie = nE;
        this.energieAttive = 0;
        this.numDanni = nD;
    }
    void addEnergy(){
        this.energieAttive += 1;
    }

    void setTipo(Energy e){
        this.tipo = e;
    }
    String getName(){
        return this.name;
    }
    int getEnergie(){
        return this.numEnergie;
    }
    int getEnergieAttive(){
        return this.energieAttive;
    }
    int getDanni(){
        return this.numDanni;
    }
}
