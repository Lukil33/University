package Utility;

import View.MainGui;

public class Controller{
    private Dati dati;
    private MainGui gui;
    public Controller(){
        this.dati = new Dati();
        this.gui = new MainGui(this);
    }
    public void move(){

    }
    public MainGui getGui(){
        return this.gui;
    }
}
