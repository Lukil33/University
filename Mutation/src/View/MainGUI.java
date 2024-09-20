package View;

import Utility.Controller;
import Utility.Slot;
import com.sun.tools.javac.Main;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainGUI extends BorderPane {
    private StatsPane spane;
    private ListPane lpane;
    private Controller control;
    private SlotPane slotpane;
    public MainGUI(Controller c){
        this.control = c;
        redraw();
    }
    public void redraw(){
        this.getChildren().clear();
        this.spane = new StatsPane(control.ger);
        this.lpane = new ListPane(control);
        this.slotpane = new SlotPane(control.s);
        this.setCenter(spane);
        this.setBottom(lpane);
        this.setRight(slotpane);
    }
}