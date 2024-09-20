package Utility;

import Blocks.Explosive;
import GUI.MainGui;

public class Controller{
    public MainGui gui;
    public Map m;
    public int dimMap;
    public int dimCell;
    public int dimText;
    public int number_elements;
    private static final int MAXMAPDIM = 33;
    private static final int MINCELLDIM = 20;
    public Controller(){
        gui = new MainGui(this, MAXMAPDIM);
    }
    public void setStarter(int dim, int num){
        this.dimMap = dim;
        this.number_elements = num;
        this.dimCell = MINCELLDIM*MAXMAPDIM/dim;
        this.dimText = (dimCell/4)*3;
        gui.drawFirstTime();
    }
    public void startTheGame(Coord c){
        m = new Map(dimMap,number_elements,c);
        gui.redraw();
    }
    public void changeFlag(Coord c){
        if(m.getElement(c).isFlagged()){
            m.insertFlag(c,-1);
            gui.stpane.remFlag();
        }else{
            m.insertFlag(c,+1);
            gui.stpane.addFlag();

        }
    }
    public void discover(Coord c){
        try{
            m.discover(c);
            gui.redraw();
            if(m.finalCheck()){
                gui.gameOver(true);
            }
        }catch(Explosive e){
            gameOver();
        }
    }
    private void gameOver(){
        m.discoverAllBombs();
        gui.gameOver(false);
    }
}