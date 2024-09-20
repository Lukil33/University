package View;

import Mutation.Combattimento.Combattimento;
import Mutation.Magia.Magia;
import Mutation.Mutation;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MutationPane extends StackPane{
    private static final int DIM = 40;
    private Mutation mut;
    MutationPane(Mutation m){
        this.mut = m;
        this.getChildren().add(background());
        this.getChildren().add(appropriateText());
    }
    private Rectangle background() {
        Rectangle sfondo = new Rectangle(DIM,DIM);
        sfondo.setFill(selectColor());
        sfondo.setStroke(Color.BLACK);
        return sfondo;
    }
    private Color selectColor(){
        if(mut instanceof Combattimento){
            return Color.RED;
        }else if(mut instanceof Magia){
            return Color.ROYALBLUE;
        }else{
            return Color.GREEN;
        }
    }
    private Text appropriateText(){
        String s = "";
        if(mut.isActive()){
            s += "-";
        }else{
            s += "+";
        }
        return new Text(s + mut.toString());
    }
}
