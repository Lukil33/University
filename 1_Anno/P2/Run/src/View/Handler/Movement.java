package View.Handler;

import Utility.Controller;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Movement implements EventHandler<KeyEvent>{
    public Movement(Controller c){

    }
    @Override
    public void handle(KeyEvent keyEvent){
        System.out.println("Bruh");
        if(keyEvent.getCharacter().equals(" ")){
            System.out.println("Palle");
        }
        System.out.println("Gialle");
    }
}
