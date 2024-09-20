package View;

import View.Personaggi.*;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Random;

public class MapPane extends StackPane{
    private final int NUM_OSTACOLI = 6;
    private final int WIDTH_SFONDO = 500;
    private final int HEIGHT_SFONDO = 200;
    MapPane(){
        initilizeRectangle();
        insertRandomBlock();
        insertFinishLine();
        insertMainCharacter();
    }
    private void initilizeRectangle(){
        Rectangle sfondo = new Rectangle(WIDTH_SFONDO,HEIGHT_SFONDO);
        sfondo.setFill(Color.TRANSPARENT);
        sfondo.setStroke(Color.BLACK);
        this.getChildren().add(sfondo);
        this.setAlignment(Pos.CENTER);
    }
    private void insertRandomBlock(){
        Shape oggetto = null;
        for(int i=0; i<NUM_OSTACOLI; i++){
            if(i%2 == 0){
                oggetto = new CirclePane();
            }else{
                oggetto = new SquarePane();
            }
            setRandomCoordinates(oggetto);
            this.getChildren().add(oggetto);
        }
    }
    private void setRandomCoordinates(Shape o){
        Random r = new Random();
        int Xbound = WIDTH_SFONDO /2 - SquarePane.DIM/2;
        int Ybound = HEIGHT_SFONDO/2 - SquarePane.DIM/2;
        o.setTranslateX(r.nextInt(-Xbound,Xbound));
        o.setTranslateY(r.nextInt(-Ybound,Ybound));
    }
    private void insertFinishLine(){
        Rectangle fine = new Rectangle(10,200,Color.LIGHTBLUE);
        fine.setTranslateX(245);
        this.getChildren().add(fine);
    }
    private void insertMainCharacter(){
        PersonaggioPane p = new PersonaggioPane();
        p.setTranslateX(-245);
        this.getChildren().add(p);
    }
}
