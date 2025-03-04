package GUI.Clickable;

import Blocchi.Interfacce.Block;
import GUI.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class Intern extends BlockPane{
    public Intern(Block b){
        super(b);
        Listener l = new Listener();
        l.handle(new Event(MouseEvent.MOUSE_PRESSED));
    }
    public class Listener implements EventHandler{
        @Override
        public void handle(Event event) {
            addEventHandler(event.getEventType(),(Event e) -> System.out.println(blocco));
        }
    }
}