package View;

import Movies.Film;
import Utility.Controller;
import View.Center.InformationPane;
import View.Header.HeaderPane;
import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane{
    private HeaderPane hpane;
    private InformationPane ipane;
    private RightButtonPane rbpane;
    private LeftButtonPane lbpane;
    public MainGui(Controller c){
        this.rbpane = new RightButtonPane(c);
        this.lbpane = new LeftButtonPane(this);
        this.hpane = new HeaderPane(c);
        this.setRight(rbpane);
        this.setLeft(lbpane);
        this.setTop(hpane);
    }
    public void informationRedraw(Film m){
        this.ipane = new InformationPane(m);
        this.setCenter(ipane);
    }
    public void headerRedraw() {
        hpane.redraw();
    }
    void removeIpane(){
        this.getChildren().remove(ipane);
    }
}
