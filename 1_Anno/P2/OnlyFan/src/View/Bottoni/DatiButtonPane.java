package View.Bottoni;

import Utility.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class DatiButtonPane extends VBox{
    public DatiButtonPane(Controller c){
        Button pmese = new Button("Pros Mese");
        pmese.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> c.cambiaMese());
        Button soldi = new Button("+100 Fondi");
        soldi.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> c.addMoney());
        this.getChildren().addAll(pmese,soldi);
        this.setAlignment(Pos.TOP_LEFT);
    }
}
