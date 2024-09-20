package View;

import Utility.Controller;
import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane{
    private final Controller control;
    private final StatsPane spane;
    private final CenterPane cpane;
    public MainGui(Controller c){
        this.control = c;
        this.spane = new StatsPane(c.getStats());
        this.cpane = new CenterPane(c);
        this.setTop(spane);
        this.setCenter(cpane);
    }
    public void statsRedraw(){
        this.spane.redraw();
    }
    public void centerRedraw(){
        this.cpane.redraw();
    }
}
