package View.Personaggi;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class PersonaggioPane extends Group{
    private static final int RADIUS = 5;
    private static final int DIM_BASE = 10;
    private static final int DIM_HEIGHT = 30;
    public PersonaggioPane(){
        initialize();
    }
    private void initialize(){
        Circle testa = new Circle(RADIUS, Color.BLACK);
        double x = testa.getCenterX();
        double y = testa.getCenterY();
        Polygon corpo = new Polygon(x,y,
                                    x-DIM_BASE/2,y+DIM_HEIGHT,
                                    x+DIM_BASE/2,y+DIM_HEIGHT);
        corpo.setFill(Color.GREEN);
        this.getChildren().addAll(testa,corpo);
    }
}
