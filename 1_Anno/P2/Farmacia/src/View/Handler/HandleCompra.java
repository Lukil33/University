package View.Handler;

import Utility.Controller;
import View.ArrayMed.MedPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandleCompra implements EventHandler<ActionEvent>{
    private Controller control;
    private MedPane medPane;
    public HandleCompra(Controller c, MedPane mp){
        this.control = c;
        this.medPane = mp;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.control.compra(medPane.getMed());
    }
}
