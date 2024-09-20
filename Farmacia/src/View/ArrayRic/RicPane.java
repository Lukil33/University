package View.ArrayRic;

import Ricette.Ricetta;
import Utility.Dati;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.Date;

public class RicPane extends Button{
    RicPane(Ricetta r){
        if(r.isActive()){
            this.setText("Ricetta per: " + r.getName() + "\n" + dataValida(r.getData()) + "\n(selezionata)");
        }else{
            this.setText("Ricetta per: " + r.getName() + "\n" + dataValida(r.getData()));
        }
        if(r.isActive()||isScaduto(r.getData())){
            this.setTextFill(Color.GRAY);
        }
    }
    private String dataValida(Date d){
        if(isScaduto(d)){
            return "scaduta";
        }else{
            return "Valida fino al " + d.toString();
        }
    }
    private boolean isScaduto(Date d){
        return d.before(Dati.getDate());
    }
}
