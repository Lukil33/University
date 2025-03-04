package Utility;

import Exceptions.FirstPiastrella;
import Exceptions.LastPiastrella;
import Piastrelle.NormalPiastrella;
import View.MainGui;

public class Controller{
    private MainGui gui;
    private Archivio archivio;
    public Controller(){
        this.archivio = new Archivio();
        this.gui = new MainGui(this);
    }
    public NormalPiastrella getPiastrella(){
        return this.archivio.getPiastrella();
    }
    public void showNext(){
        try{
            lastCheck();
            this.archivio.changeSelected(+1);
            this.gui.redraw();
        }catch(LastPiastrella ignored){}
    }
    public void showPrev(){
        try{
            firstCheck();
            this.archivio.changeSelected(-1);
            this.gui.redraw();
        }catch(FirstPiastrella ignored){}
    }
    public void firstCheck() throws FirstPiastrella{
        this.archivio.firstCheck();
    }
    public void lastCheck() throws LastPiastrella{
        this.archivio.lastCheck();
    }
    public MainGui getGui(){
        return this.gui;
    }
}
