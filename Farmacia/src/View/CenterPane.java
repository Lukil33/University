package View;

import Utility.Controller;
import View.ArrayMed.MedPane;
import View.Handler.HandleCompra;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CenterPane extends VBox{
    private final Button compra = new Button("Compra");
    CenterPane(Controller c,MedPane mp){
        this.compra.addEventHandler(ActionEvent.ACTION, new HandleCompra(c, mp));
        mp.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().addAll(mp,compra);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
    }
}
