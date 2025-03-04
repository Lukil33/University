package Celle;

import javafx.scene.paint.Color;

public abstract class AbsCell{
    protected int value;
    AbsCell(){}
    public abstract Color getColor();
    public int getValue(){
        return this.value;
    }
}
