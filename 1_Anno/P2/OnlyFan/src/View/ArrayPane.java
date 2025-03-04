package View;

import Utility.Controller;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ArrayPane extends GridPane{
    private Controller control;
    ArrayPane(Controller c){
        this.control = c;
        redraw();
    }
    void redraw(){
        this.getChildren().clear();
        for(int i=0; i<control.getRegisterDim(); i++){
            FanPane fp = new FanPane(control.getElement(i));
            int var = i;
            fp.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> control.select(var));
            this.add(fp,0,i);
        }
    }
}
