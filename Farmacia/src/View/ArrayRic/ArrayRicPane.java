package View.ArrayRic;

import Utility.Controller;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ArrayRicPane extends VBox{
    private Controller control;
    public ArrayRicPane(Controller c){
        super(10);
        this.control = c;
        redraw();
    }
    public void redraw(){
        this.getChildren().clear();
        for(int i=0; i<control.numRic(); i++){
            RicPane rp = new RicPane(control.getRic(i));
            int Var = i;
            rp.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> control.selectRicetta(Var));
            this.getChildren().add(rp);
        }
        this.setAlignment(Pos.TOP_LEFT);
    }
}
