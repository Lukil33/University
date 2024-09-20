package View;

import Utility.Controller;
import View.Bottoni.DatiButtonPane;
import View.Bottoni.OrderButtonPane;
import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane{
    private final Controller control;
    private DatiPane dpane;
    private ArrayPane apane;
    public MainGui(Controller c){
        this.control = c;
        initialize();
    }
    private void initialize(){
        this.dpane = new DatiPane();
        DatiButtonPane dbpane = new DatiButtonPane(control);
        OrderButtonPane obpane = new OrderButtonPane(control);
        this.apane = new ArrayPane(control);

        this.setTop(dpane);
        this.setLeft(dbpane);
        this.setRight(obpane);
        this.setCenter(apane);
    }
    public void datiArrayRedraw(){
        this.getChildren().remove(dpane);
        this.getChildren().remove(apane);

        this.dpane.redraw();
        this.apane.redraw();

        this.setTop(dpane);
        this.setCenter(apane);
    }
}
