package GUI.Clickable;

import Blocchi.Interfacce.Block;
import GUI.*;
import InterfacciaUtente.Inventory;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Anonimous extends BlockPane{
    private Inventory i;
    public Anonimous(Block b, Inventory inv){
        super(b);
        this.i = inv;
        anonimo.handle(new Event(MouseEvent.MOUSE_PRESSED));
    }
    EventHandler anonimo = new EventHandler(){
        @Override
        public void handle(Event event){
            addEventHandler(event.getEventType(), (Event e) -> System.out.println(blocco));
        }
    };
}
