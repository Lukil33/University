package View;

import Utility.DatiPersonali;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class DatiPane extends HBox{
    DatiPane(){
        redraw();
    }
    void redraw(){
        this.getChildren().clear();
        Text cap = new Text("Capitale: " + DatiPersonali.getCapitale() + " ");
        Text spe = new Text("Spesa Mensile: " + DatiPersonali.getSpesa() + " ");
        Text mes = new Text("Mesi Trascorsi: " + DatiPersonali.getMese() + " ");
        this.getChildren().addAll(cap,spe,mes);
    }
}