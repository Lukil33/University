package Utility;

import Exceptions.ImpossibleFan;
import Fan.Alimentazione.Elettrica.Batteria;
import Fan.Alimentazione.Elettrica.Presa;
import Fan.Alimentazione.Meccanica.Meccanici;
import Fan.Fan;
import Fan.Tipologia.Parete;
import Fan.Tipologia.Piantana;
import Fan.Tipologia.Soffitto;
import Utility.Comparatori.TypeComp;

import java.util.ArrayList;
import java.util.Comparator;

public class Registro extends ArrayList<Fan>{
    Registro(){
        initialize();
    }
    private void initialize(){
        try{
            this.add(new Fan("Ariete",new Piantana(),new Batteria()));
            this.add(new Fan("Bosch",new Parete(),new Presa()));
            this.add(new Fan("Bosch",new Parete(),new Meccanici()));
            this.add(new Fan("Bosch",new Soffitto(),new Batteria()));
            this.add(new Fan("Parkside",new Soffitto(),new Presa()));
        }catch(ImpossibleFan i){
            this.clear();
            System.out.println("Impossible Fan");
        }
        sortArray(new TypeComp());
    }
    void sortArray(Comparator c){
        this.sort(c);
    }
    Fan getElement(int i){
        return this.get(i);
    }
    Fan mostCostActive(){
        Fan res = null;
        for(Fan gf : this){
            if(gf.isActive()){
                if(res == null || res.getCosto()<gf.getCosto()){
                    res = gf;
                }
            }
        }
        return res;
    }
    int getDim(){
        return this.size();
    }
}
