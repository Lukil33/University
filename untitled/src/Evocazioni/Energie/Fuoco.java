package Evocazioni.Energie;

import javafx.scene.paint.Color;

public class Fuoco implements Energy{
    private static final Color colore = Color.FIREBRICK;
    @Override
    public Color getColor() {
        return colore;
    }
    @Override
    public boolean isStrongAgainst(Energy e) {
        return e instanceof Acqua;
    }
}
