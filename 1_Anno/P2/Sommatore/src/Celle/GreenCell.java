package Celle;

import javafx.scene.paint.Color;

public class GreenCell extends AbsBorderCell{
    private static final Color colore = Color.GREEN;
    public GreenCell(){
    }
    @Override
    public void modifyValue(int i){
        this.value = i;
    }
    @Override
    public Color getColor(){
        return colore;
    }
}
