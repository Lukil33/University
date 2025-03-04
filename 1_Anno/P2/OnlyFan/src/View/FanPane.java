package View;

import Fan.Fan;
import Utility.DatiPersonali;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class FanPane extends HBox{
    FanPane(Fan gf){
        Circle selectable = new Circle(25);
        setColor(gf,selectable);
        VBox testo = new VBox();
        modifyTesto(gf,testo);
        this.getChildren().addAll(selectable,testo);
    }
    private void setColor(Fan gf, Circle c){
        if(gf.isActive()){
            c.setFill(Color.RED);
        }else{
            c.setFill(Color.BLUE);
        }
        if(DatiPersonali.getSpesa() + gf.getCosto() > DatiPersonali.getCapitale()){
            c.setStroke(Color.GRAY);
        }else{
            c.setStroke(Color.BLACK);
        }
        c.setStrokeWidth(4);
    }
    private void modifyTesto(Fan gf, VBox t){
        Text nome = new Text(gf.getName());
        Text dati = new Text("Tipo: " + gf.getTipo() + " Alimentazione: " + gf.getAlimentazione());
        Text costo = new Text("Costo: " + gf.getCosto());
        t.getChildren().addAll(nome,dati,costo);
    }
}
