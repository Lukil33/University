package Utility;

import Celle.*;
import Exceptions.*;

public class Array{
    private final AbsBorderCell[] gArray;
    private final AbsBorderCell[] rArray;
    private final Map map;
    Array(Map m){
        this.map = m;
        this.gArray = new AbsBorderCell[m.getDimMappa()];
        this.rArray = new AbsBorderCell[m.getDimMappa()];
        initialize();
    }
    private void initialize(){
        for(int i=0; i<map.getDimMappa(); i++){
            this.gArray[i] = new GreenCell();
            this.rArray[i] = new RedCell();
        }
        modifyAllGreenValue();
        modifyAllRedValue();
    }
    void modifyAllGreenValue(){
        for(int i=0; i<map.getDimMappa(); i++){
            modifySinglGreenValue(i);
        }
    }
    void modifySinglGreenValue(int i){
        this.gArray[i].modifyValue(map.sumValRow(i));
    }
    void modifyAllRedValue(){
        for(int i=0; i<map.getDimMappa(); i++){
            modifySinglRedValue(i);
        }
    }
    void modifySinglRedValue(int i){
        this.rArray[i].modifyValue(map.sumValCol(i));
    }
    AbsBorderCell getGreenCell(int i){
        return this.gArray[i];
    }
    AbsBorderCell getRedCell(int i){
        return this.rArray[i];
    }
    void check() throws Win,Lose,Draw{
        boolean greenWin = false;
        boolean redWin = false;
        for(int i=0; i<map.getDimMappa(); i++){
            if(this.gArray[i].getValue() == 10){
                greenWin = true;
            }
            if(this.rArray[i].getValue() == 10){
                redWin = true;
            }
        }
        if(greenWin && redWin){
            throw new Draw();
        }else if(greenWin){
            throw new Win();
        }else if(redWin){
            throw new Lose();
        }
    }
}
