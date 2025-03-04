package Utility;

import View.MainGUI;
import Exception.SlotFull;

public class Controller{
    public Geraldo ger;
    public MainGUI gui;
    public MutazioniDisponibili m;
    public Slot s;
    public Controller(){
        this.ger = new Geraldo();
        this.m = new MutazioniDisponibili();
        this.s = new Slot();
        this.gui = new MainGUI(this);
    }
    public void applyMutation(int i){
        try{
            s.searchInSlot(m.getMutation(i));
            m.applyMutation(i,ger);
            gui.redraw();
        }catch(SlotFull s){}
    }
}
