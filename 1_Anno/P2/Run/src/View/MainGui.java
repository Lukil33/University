package View;

import Utility.Controller;
import View.Handler.Movement;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.util.logging.Handler;

public class MainGui extends BorderPane{
    private HeaderPane hpane;
    private MapPane mpane;
    private Movement handler;
    public MainGui(Controller c){
        this.hpane = new HeaderPane();
        this.mpane = new MapPane();
        this.handler = new Movement(c);
        this.setTop(hpane);
        this.setCenter(mpane);
        setHandler();
    }
    private void setHandler(){
        this.addEventHandler(KeyEvent.KEY_PRESSED, handler);
    }
}
