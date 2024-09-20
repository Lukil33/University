package View.Energy;

import Evocazioni.Energie.Energy;
import Utility.Controller;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class EnergyArrayPane extends VBox{
    private final Controller control;
    private final boolean side;
    public EnergyArrayPane(Controller c, boolean s){
        super(10);
        this.control = c;
        this.side = s;

        for(int i=0; i<dim(); i++){
            EnergyPane ep = new EnergyPane(getEnergy(i));
            int Var = i;
            ep.addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> control.useEnergy(getEnergy(Var), side));
            this.getChildren().add(ep);
        }
    }
    private int dim(){
        if(this.side){
            return control.getAttackEnergySize();
        }else{
            return control.getDefenseEnergySize();
        }
    }
    private Energy getEnergy(int i){
        if(this.side){
            return this.control.getAttackEnergy(i);
        }else{
            return this.control.getDefenseEnergy(i);
        }
    }
}
