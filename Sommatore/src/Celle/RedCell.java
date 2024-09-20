package Celle;

import javafx.scene.paint.Color;

public class RedCell extends AbsBorderCell{
    private static final Color colore = Color.RED;
    public RedCell(){}
    @Override
    public void modifyValue(int i){
        this.value = i;
    }
    @Override
    public Color getColor(){
        return colore;
    }
}
