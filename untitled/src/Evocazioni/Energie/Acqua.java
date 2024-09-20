package Evocazioni.Energie;

import javafx.scene.paint.Color;

public class Acqua implements Energy{
    private static final Color colore = Color.AQUAMARINE;
    @Override
    public Color getColor(){
        return colore;
    }
    @Override
    public boolean isStrongAgainst(Energy e) {
        return e instanceof Fuoco;
    }
}
