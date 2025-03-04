package Utility;

import Medicine.AbsMed;
import Medicine.MedDaBanco;
import Medicine.MedRicNonRip;
import Medicine.MedRicRip;

import java.util.ArrayList;
import java.util.Date;

public class RegistroMed extends ArrayList<AbsMed>{
    RegistroMed(){
        initialize();
    }
    private void initialize(){
        this.add(new MedDaBanco("Benagol",10,new Date(Dati.getDate().getTime()+Dati.getDayDuration())));
        this.add(new MedDaBanco("Brufen200",8,new Date(Dati.getDate().getTime()+Dati.getDayDuration())));
        this.add(new MedRicNonRip("Brufen800",20,new Date(Dati.getDate().getTime()+Dati.getDayDuration())));
        this.add(new MedRicRip("Oki",4,12,new Date(Dati.getDate().getTime()+Dati.getDayDuration())));
        this.add(new MedRicRip("Fluifort",2,18,new Date(Dati.getDate().getTime()-Dati.getDayDuration())));
        this.add(new MedRicRip("Tachipirina1000",3,6,new Date(Dati.getDate().getTime()+Dati.getDayDuration())));
    }
    int getSize(){
        return this.size();
    }
    AbsMed getElement(int i){
        return this.get(i);
    }
}
