package GUI;

import Utility.Controller;
import javafx.scene.layout.*;

public class MainGui extends BorderPane{
    protected Controller control;
    private MapPane mpane;
    private StarterPane spane;
    public StatsPane stpane;
    public MainGui(Controller c, int Mdim){
        this.control = c;
        this.spane = new StarterPane(c, Mdim);
        this.setCenter(spane);
    }
    public void drawFirstTime(){
        this.getChildren().clear();
        this.mpane = new MapPane(control);
        this.stpane = new StatsPane(control.number_elements);
        this.setCenter(mpane);
        this.setTop(stpane);
    }
    public void redraw(){
        this.getChildren().clear();
        this.mpane.redraw(control.m);
        this.stpane.redraw();
        this.setCenter(mpane);
        this.setTop(stpane);
    }
    public void gameOver(boolean x){
        this.getChildren().clear();
        this.mpane.mapRedraw(control.m);
        if(x){
            this.stpane.victory();
        }else{
            this.stpane.deafeat();
        }
        this.setCenter(mpane);
        this.setTop(stpane);
    }
}
