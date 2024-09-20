package View.ArrayMed;

import Medicine.AbsMed;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MedPane extends VBox{
    private AbsMed m;
    MedPane(AbsMed med){
        this.m = med;
        Text name = new Text(med.getName());
        Text costi = new Text("Costo Base: " + med.getCosto() + "$, Scontato a " + med.getPrezzoScontato());
        Text scadenza = new Text(med.getDate());
        Text tipo = new Text(med.getTipo());
        this.getChildren().addAll(name,costi,scadenza,tipo);
    }
    public AbsMed getMed(){
        return this.m;
    }
}
