package Celle;

import Exceptions.ValTooHigh;
import Exceptions.ValTooLow;
import javafx.scene.paint.Color;

public class BlueCell extends AbsCenterCell{
    private static final Color colore = Color.BLUE;
    public BlueCell(){}
    @Override
    public void modifyValue(){
        this.value -= 1;
        try{
            check();
        }catch(ValTooLow v){
           this.value = MAX_BOUND;
        }
    }
    private void check() throws ValTooLow{
        if(this.value < 0){
            throw new ValTooLow();
        }
    }
    @Override
    public Color getColor(){
        return colore;
    }
}
