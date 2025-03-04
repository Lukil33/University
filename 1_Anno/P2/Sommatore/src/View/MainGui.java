package View;

import Utility.Controller;
import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane{
    private MapPane mpane;
    private ButtonPane bpane;
    public MainGui(Controller c){
        this.mpane = new MapPane(c);
        this.setCenter(mpane);

        this.bpane = new ButtonPane(c);
        this.setBottom(bpane);
    }
    public void mapRedraw(){
        this.mpane.redraw();
    }
    public void finalButtonRedraw(){
        this.bpane.finalRedraw();
    }
}
