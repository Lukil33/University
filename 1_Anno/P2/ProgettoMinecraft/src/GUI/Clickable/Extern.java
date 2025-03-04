package GUI.Clickable;

import Blocchi.Interfacce.Block;
import GUI.BlockPane;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Extern extends BlockPane{
    public Extern(Block b){
        super(b);
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, (Event e) -> {});
    }
}