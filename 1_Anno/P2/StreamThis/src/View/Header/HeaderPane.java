package View.Header;

import Exceptions.TooLeft;
import Exceptions.TooRight;
import Utility.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class HeaderPane extends HBox{
    private Controller control;
    private Button lButt = new Button("<");
    private Button rButt = new Button(">");
    public HeaderPane(Controller c){
        this.control = c;
        lButt.addEventHandler(ActionEvent.ACTION, (ActionEvent e)->swipeLeft());
        rButt.addEventHandler(ActionEvent.ACTION, (ActionEvent e)->swipeRight());
        redraw();
    }
    public void redraw(){
        this.getChildren().clear();
        this.getChildren().add(lButt);

        for(int i=0; i<3; i++){
            int res = i+control.getFocus();
            StackCell sc = new StackCell(control.getElement(res));
            sc.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e)-> control.selectMovie(res));
            this.getChildren().add(sc);
        }

        this.getChildren().add(rButt);
    }
    public void swipeLeft(){
        try {
            control.swipe(-1);
            redraw();
        }catch(TooLeft tl){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Out of bound");
            a.setContentText("non puoi più scorrere a sinistra");
            a.showAndWait();
        }catch(TooRight tr){
            System.out.println("Questo non dovrebbe succedere");
        }
    }
    public void swipeRight(){
        try {
            control.swipe(1);
            redraw();
        }catch(TooRight tr){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Out of bound");
            a.setContentText("non puoi più scorrere a destra");
            a.showAndWait();
        }catch(TooLeft tl){
            System.out.println("Questo non dovrebbe succedere");
        }
    }
}
