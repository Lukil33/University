package View;

import Utility.Dati;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class HeaderPane extends HBox{
    HeaderPane(){
        redraw();
    }
    void redraw(){
        this.getChildren().clear();
        Text punteggio = new Text("Punteggio: " + Dati.getPunteggio() + " ");
        Text vite = new Text(" Vite: " + Dati.getVite());
        this.getChildren().addAll(punteggio,vite);
        this.setAlignment(Pos.CENTER);
    }
}
