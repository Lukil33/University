package Piastrelle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BicolorPiastrella extends NormalPiastrella{
    private Shape interno;
    private Color internColor;
    public BicolorPiastrella(String code, double side, double price, Materials material, boolean cc, Shape interno) {
        super(code, side, price, material, cc);
        this.interno = interno;
        setStartingColor();
    }
    private void setStartingColor(){
        this.internColor = Color.WHEAT;
    }
    public Shape getShape(){return this.interno;}
    public Color getInternColor(){return this.internColor;}
    public void changeIntenalColor(){
        this.internColor = changeColor(this.internColor);
    }
}
