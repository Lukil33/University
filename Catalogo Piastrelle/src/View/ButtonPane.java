package View;

import Exceptions.FirstPiastrella;
import Exceptions.LastPiastrella;
import Utility.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ButtonPane extends HBox{
    ButtonPane(Controller c){
        Button prev = new Button("<prev");
        Button next = new Button("next>");
        prev.setOnAction( e -> c.showPrev());
        next.setOnAction( e -> c.showNext());
        try{
            c.firstCheck();
        }catch(FirstPiastrella f){
            prev.setTextFill(Color.GRAY);
        }
        try{
            c.lastCheck();
        }catch(LastPiastrella l){
            next.setTextFill(Color.GRAY);
        }
        this.getChildren().addAll(prev,next);
    }
}
