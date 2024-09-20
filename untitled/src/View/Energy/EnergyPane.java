package View.Energy;

import Evocazioni.Energie.Energy;
import javafx.scene.shape.Rectangle;

public class EnergyPane extends Rectangle{
    EnergyPane(Energy e){
        this.setHeight(30);
        this.setWidth(70);
        this.setFill(e.getColor());
    }
}
