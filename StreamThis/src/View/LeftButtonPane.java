package View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftButtonPane extends VBox implements EventHandler<ActionEvent>{
    private MainGui mg;
    LeftButtonPane(MainGui gui){
        this.mg = gui;
        Button clear = new Button("Clear");
        clear.setOnAction(this);
        this.getChildren().add(clear);
    }
    @Override
    public void handle(ActionEvent actionEvent){
        mg.removeIpane();
    }
}
