package Ricette;

import Exceptions.RicettaUsata;

import java.util.Date;

public class Ricetta{
    private final String name;
    private final Date data;
    private int numOfUse;
    private boolean isActive;
    public Ricetta(String n, Date d){
        this.name = n;
        this.data = d;
        this.numOfUse = 0;
        this.isActive = false;
    }
    public void aumentaUsi(){
        this.numOfUse += 1;
    }
    public void checkNumOfUse(int x) throws RicettaUsata {
        if(this.numOfUse >= x){
            throw new RicettaUsata();
        }
    }
    public String getName() {
        return this.name;
    }
    public Date getData(){
        return this.data;
    }
    public boolean isActive(){
        return this.isActive;
    }
    public void changeActivity(){
        this.isActive = !this.isActive;
    }
}
