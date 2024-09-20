package Evocazioni.Energie;

import javafx.scene.paint.Color;

public class Neutra implements Energy{
    private static final Color colore = Color.HONEYDEW;
    @Override
    public Color getColor() {
        return colore;
    }
    @Override
    public boolean isStrongAgainst(Energy e) {
        return false;
    }
}
