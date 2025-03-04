package Utility;

import Ricette.Ricetta;

import java.util.ArrayList;
import java.util.Date;

public class RegistroRic extends ArrayList<Ricetta>{
    RegistroRic(){
        initialize();
    }
    private void initialize(){
        this.add(new Ricetta("Brufen800",new Date(Dati.getDate().getTime()-Dati.getDayDuration())));
        this.add(new Ricetta("Tachipirina1000",new Date(Dati.getDate().getTime()+Dati.getDayDuration())));
        this.add(new Ricetta("Fluifort",new Date(Dati.getDate().getTime()+Dati.getDayDuration())));
    }
    int getSize(){
        return this.size();
    }
    Ricetta getElement(int i){
        return this.get(i);
    }
}
