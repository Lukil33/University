package View;

import Utility.Controller;
import View.ArrayPane.*;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class CenterPane extends HBox{
    private final Controller control;
    CenterPane(Controller c){
        super(10);
        this.control = c;
        redraw();
    }
    void redraw(){
        this.getChildren().clear();
        MainArrayPane main = new MainArrayPane(control);
        SecondaryArrayPane secondary = new SecondaryArrayPane(control);
        ContractArrayPane contract = new ContractArrayPane(control);
        DlcArrayPane dlc = new DlcArrayPane(control);
        this.getChildren().addAll(main,secondary,contract,dlc);
        this.setAlignment(Pos.TOP_CENTER);
    }
}
