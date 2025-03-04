package View;

import Utility.Geraldo;
import Mutation.Magia.Magia;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class StatsPane extends VBox{
    StatsPane(Geraldo g){
        Text livello = new Text("Lvl: "+g.getLevel());
        Text forza = new Text("Str: "+g.getStrenght());
        Text velocità = new Text("Vel: "+g.getVelocity()+"\n");
        Text tolleranza = new Text("Tol: "+g.getTollerance()+"\n");
        Text magie = new Text(printSpells(g.getSpells()));
        this.getChildren().addAll(livello,forza,velocità,tolleranza, magie);
    }
    private String printSpells(List<Magia> l){
        String s = "Spells: \n";
        for(Magia m : l){
            s += m.toString()+"\n";
        }
        return s;
    }
}
