package Utility;

import Celle.AbsCell;
import Celle.AbsCenterCell;
import Celle.BlueCell;
import Celle.GrayCell;

import java.util.Random;

public class Map{
    private static final int DIM_MAPPA = 4;
    private final AbsCenterCell[][] mappa;
    Map(){
        this.mappa = new AbsCenterCell[DIM_MAPPA][DIM_MAPPA];
        initialize();
    }
    private void initialize(){
        for(int x=0; x<DIM_MAPPA; x++){
            for(int y=0; y<DIM_MAPPA; y++){
                this.mappa[x][y] = getRandomCell();
            }
        }
    }
    private AbsCenterCell getRandomCell(){
        Random r = new Random();
        AbsCenterCell res = null;
        if(r.nextInt() % 2 == 0){
            res = new BlueCell();
        }else{
            res = new GrayCell();
        }
        return res;
    }
    int sumValRow(int i){
        int res = 0;
        for(int y=0; y<DIM_MAPPA; y++){
            res += this.mappa[i][y].getValue();
        }
        return res;
    }
    int sumValCol(int i){
        int res = 0;
        for(int x=0; x<DIM_MAPPA; x++){
            res += this.mappa[x][i].getValue();
        }
        return res;
    }
    void changeRow(int i){
        for(int y=0; y<DIM_MAPPA; y++){
            this.mappa[i][y].modifyValue();
        }
    }
    void changeCol(int i){
        for(int x=0; x<DIM_MAPPA; x++){
            this.mappa[x][i].modifyValue();
        }
    }
    int getDimMappa(){
        return DIM_MAPPA;
    }
    AbsCell getCell(int x, int y){
        return this.mappa[x][y];
    }
}
