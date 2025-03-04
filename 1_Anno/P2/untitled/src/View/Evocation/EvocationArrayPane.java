package View.Evocation;

import Evocazioni.Energie.Energy;
import Evocazioni.Evocation;
import Utility.Controller;
import View.Energy.EnergyPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class EvocationArrayPane extends HBox{
    private final Controller control;
    private boolean side;
    public EvocationArrayPane(Controller c, boolean s){
        super(10);
        this.control = c;
        this.side = s;

        for(int i=0; i<dim(); i++){
            EvocationPane ep = new EvocationPane(getEvocation(i));
            int Var = i;
            ep.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> control.useEvocation(getEvocation(Var), side));
            this.getChildren().add(ep);
        }
    }
    private int dim(){
        if(this.side){
            return control.getAttackEvocationSize();
        }else{
            return control.getDefenseEvocationSize();
        }
    }
    private Evocation getEvocation(int i){
        if(this.side){
            return this.control.getAttackEvocation(i);
        }else{
            return this.control.getDefenseEvocation(i);
        }
    }
}
