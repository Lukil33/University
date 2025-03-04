package View.Personaggi;

import Utility.Dati;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CirclePane extends Circle implements Penalità{
    private static final int malus = 500;
    private static final int RADIUS = SquarePane.DIM/2;
    private static final Color BACKGROUND = Color.BLUE;
    public CirclePane(){
        initialize();
    }
    private void initialize(){
        this.setRadius(RADIUS);
        this.setFill(BACKGROUND);
    }
    @Override
    public void applyPenalty() {
        Dati.removePunteggio(malus);
    }
}
