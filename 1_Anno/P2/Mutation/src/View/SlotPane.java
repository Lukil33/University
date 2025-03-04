package View;

import Mutation.Combattimento.Combattimento;
import Mutation.Combattimento.Strenght;
import Mutation.Magia.Ignition;
import Utility.Slot;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class SlotPane extends VBox{
    SlotPane(Slot s){
        Text mutazioni = new Text("Mutations:");
        Text combatArray = new Text(printArray(s.combatArray, s.MAXDIM));
        combatArray.setFill(Color.RED);
        Text magiaArray = new Text(printArray(s.magiaArray, s.MAXDIM));
        magiaArray.setFill(Color.ROYALBLUE);
        Text pozioArray = new Text(printArray(s.pozioArray, s.MAXDIM));
        pozioArray.setFill(Color.GREEN);
        Text genericArray = new Text(printArray(s.genericArray, s.MAXDIM));
        genericArray.setFill(Color.GRAY);
        this.getChildren().addAll(mutazioni,combatArray,magiaArray,pozioArray,genericArray);
    }
    public String printArray(ArrayList al, int MAXDIM){
        String res = "";
        for(int i=0; i<MAXDIM; i++){
            try {
                res += al.get(i).toString();
            }catch(IndexOutOfBoundsException e){
                res += "Empty";
            }
            if(i != MAXDIM-1){
                res += "\n";
            }
        }
        return res;
    }
}
