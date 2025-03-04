package Celle;

import Exceptions.ValTooHigh;
import Exceptions.ValTooLow;
import javafx.scene.paint.Color;

public class GrayCell extends AbsCenterCell{
    private static final Color colore = Color.GRAY;
    public GrayCell(){}
    @Override
    public void modifyValue() {
        this.value += 1;
        try{
            check();
        }catch(ValTooHigh v){
            this.value = MIN_BOUND;
        }
    }
    private void check() throws ValTooHigh {
        if(this.value > MAX_BOUND){
            throw new ValTooHigh();
        }
    }
    @Override
    public Color getColor(){
        return colore;
    }
}
