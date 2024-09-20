package Evocazioni.Energie;

import javafx.scene.paint.Color;

public interface Energy {
    Color getColor();
    boolean isStrongAgainst(Energy e);
}
