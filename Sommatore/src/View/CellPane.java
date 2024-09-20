package View;

import Celle.AbsCell;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CellPane extends StackPane{
    CellPane(AbsCell c){
        Rectangle sfondo = new Rectangle(46,46,c.getColor());
        sfondo.setStroke(Color.TRANSPARENT);
        Text numero = new Text("" + c.getValue());
        numero.setFill(Color.YELLOW);
        this.getChildren().addAll(sfondo, numero);
    }
}
