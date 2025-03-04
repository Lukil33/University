package View.Personaggi;

import Utility.Dati;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquarePane extends Rectangle implements Penalità{
    private static final int malus = 1;
    public static final int DIM = 20;
    private static final Color BACKGROUND = Color.RED;
    public SquarePane(){
        initialize();
    }
    private void initialize(){
        this.setHeight(DIM);
        this.setWidth(DIM);
        this.setFill(BACKGROUND);
    }
    @Override
    public void applyPenalty(){
        Dati.removeVite(malus);
    }
}
