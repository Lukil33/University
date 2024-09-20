package Utility;

import Exceptions.NoMoney;
import Fan.Fan;
import View.MainGui;

import java.util.Comparator;

public class Controller{
    private final MainGui gui;
    private final Registro reg;
    public Controller(){
        this.reg = new Registro();
        this.gui = new MainGui(this);
    }
    public void addMoney(){
        DatiPersonali.addCapitale();
        this.gui.datiArrayRedraw();
    }
    public void cambiaMese(){
        try{
            DatiPersonali.changeMonth();
        }catch(NoMoney e){
            Fan gf = reg.mostCostActive();
            gf.changeActivity();
            DatiPersonali.modifySpesa(-gf.getCosto());
            cambiaMese();
        }
        this.gui.datiArrayRedraw();
    }
    public void sort(Comparator<Fan> c){
        this.reg.sortArray(c);
        this.gui.datiArrayRedraw();
    }
    public void select(int i){
        Fan gf = this.reg.getElement(i);
        gf.changeActivity();
        if(gf.isActive()){
            DatiPersonali.modifySpesa(gf.getCosto());
        }else{
            DatiPersonali.modifySpesa(-gf.getCosto());
        }
        this.gui.datiArrayRedraw();
    }
    public int getRegisterDim(){
        return this.reg.getDim();
    }
    public Fan getElement(int i){
        return this.reg.getElement(i);
    }
    public MainGui getGui(){
        return this.gui;
    }
}