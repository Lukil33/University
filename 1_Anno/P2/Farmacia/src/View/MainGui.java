package View;

import Utility.Controller;
import View.ArrayMed.ArrayMedPane;
import View.ArrayMed.MedPane;
import View.ArrayRic.ArrayRicPane;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane{
    private final Controller control;
    private ArrayMedPane ampane;
    private ArrayRicPane arpane;
    private CenterPane cpane;
    private DatiPane dpane;
    public MainGui(Controller c){
        this.control = c;

        this.ampane = new ArrayMedPane(c);
        this.setLeft(ampane);

        this.arpane = new ArrayRicPane(c);
        this.setRight(arpane);

        this.dpane = new DatiPane();
        this.setBottom(dpane);
    }
    public void centerRedraw(MedPane mp){
        this.cpane = new CenterPane(control, mp);
        this.setCenter(cpane);
    }
    public void buttonRedraw(){
        this.arpane.redraw();
    }
    public void bottomRedraw(){
        this.dpane.redraw();
    }
}
