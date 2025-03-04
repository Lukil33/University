package View.Center;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class SeasonButton extends StackPane{
    private boolean active;
    private Button b;
    SeasonButton(int i){
        this.b = new Button("S"+i);
        activate();
        this.getChildren().add(b);
    }
    public void activate() {
        this.active = true;
        b.setTextFill(Color.BLACK);
    }
    public void deactive(){
        this.active = false;
        b.setTextFill(Color.DARKGRAY);
    }
    public boolean isActive() {
        return active;
    }
}
