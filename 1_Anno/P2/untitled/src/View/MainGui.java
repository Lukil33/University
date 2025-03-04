package View;

import Utility.Controller;
import View.Energy.EnergyArrayPane;
import View.Evocation.EvocationArrayPane;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
public class MainGui extends BorderPane{
    private final Controller control;
    public MainGui(Controller c){
        this.control = c;
        redraw();
    }
    public void redraw(){
        this.getChildren().clear();

        EvocationArrayPane aEvocationpane = new EvocationArrayPane(control, true);
        aEvocationpane.setAlignment(Pos.BOTTOM_LEFT);
        this.setBottom(aEvocationpane);

        EnergyArrayPane aEnergypane = new EnergyArrayPane(control, true);
        aEnergypane.setAlignment(Pos.BOTTOM_LEFT);
        this.setLeft(aEnergypane);

        EvocationArrayPane dEvocationpane = new EvocationArrayPane(control, false);
        dEvocationpane.setAlignment(Pos.TOP_RIGHT);
        this.setTop(dEvocationpane);

        EnergyArrayPane dEnergypane = new EnergyArrayPane(control, false);
        dEnergypane.setAlignment(Pos.TOP_RIGHT);
        this.setRight(dEnergypane);
    }
}
