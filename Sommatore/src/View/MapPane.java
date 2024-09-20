package View;

import Utility.Controller;
import javafx.scene.control.Cell;
import javafx.scene.layout.GridPane;

public class MapPane extends GridPane{
    private final Controller control;
    MapPane(Controller c){
        this.control = c;
        redraw();
    }
    void redraw(){
        this.getChildren().clear();
        for(int x=0; x<control.getDimMappa()+1; x++){
            for(int y=0; y<control.getDimMappa()+1; y++){
                if(!(x == control.getDimMappa() && y == control.getDimMappa())){
                    this.add(new CellPane(control.getCell(x,y)),y,x);
                }
            }
        }
    }
}
