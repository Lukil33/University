package View.ArrayMed;

import Utility.Controller;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class ArrayMedPane extends VBox{
    public ArrayMedPane(Controller c){
        super(10);
        for(int i=0; i<c.numMed(); i++){
            MedPane mp = new MedPane(c.getMed(i));
            int Var = i;
            mp.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> c.setCenter(new MedPane(c.getMed(Var))));
            this.getChildren().add(mp);
        }
    }
}
