package Evocazioni.Energie;

import javafx.scene.paint.Color;

public class Tenebra implements Energy{
    private static final Color colore = Color.DARKVIOLET;
    @Override
    public Color getColor() {
        return colore;
    }
    @Override
    public boolean isStrongAgainst(Energy e) {
        return true;
    }
}
