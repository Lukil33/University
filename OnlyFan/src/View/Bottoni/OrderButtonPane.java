package View.Bottoni;

import Utility.Comparatori.CostComp;
import Utility.Comparatori.TypeComp;
import Utility.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class OrderButtonPane extends VBox{
    public OrderButtonPane(Controller c){
        Button tipo = new Button("Ordina Per Tipo");
        tipo.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> c.sort(new TypeComp()));
        Button prezzo = new Button("Ordina Per Prezzo");
        prezzo.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> c.sort(new CostComp()));
        this.getChildren().addAll(tipo,prezzo);
        this.setAlignment(Pos.TOP_RIGHT);
    }
}
