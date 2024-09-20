package Utility;

import Blocks.Discovered;
import GUI.*;

public class Controller{
    public int moves;
    public int score;
    public final Map m;
    public final MainGui gui;
    public Controller(int mov){
        this.score = 0;
        this.moves = mov;
        this.m = new Map();
        this.gui = new MainGui(this);
    }
    public void discover(int x, int y){
        if(moves > 0){
            try {
                moves-=1;
                score = m.discover(x,y,score);
                redraw();
            }catch(Discovered d){
                if(m.allDiscovered()){
                    gui.stats.goodend(score);
                }
                moves+=1;
            }
        }else{
            gui.stats.end(score);
        }
    }
    public void redraw(){
        gui.stats.redraw(score,moves);
        gui.mapRedraw();
    }
}
