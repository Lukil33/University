package View;

import Utility.Dati;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class DatiPane extends FlowPane{
    DatiPane(){
        redraw();
    }
    void redraw(){
        this.getChildren().clear();
        Text costo = new Text("$ totali: " + Dati.getSoldi());
        Text data = new Text("Data Odierna: " + Dati.getDate().toString());
        this.getChildren().addAll(costo,data);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER_LEFT);
    }
}
