package Controller;

import GUI.MapPane;
import InterfacciaUtente.Map;

public class MapSimpleController implements SimpleController{
    final Map m;
    public final MapPane pane;
    public MapSimpleController(Map mappa, MapPane p){
        this.m = mappa;
        this.pane = p;
        redraw();
    }
    @Override
    public void redraw(){
        pane.removeElements();
        pane.addElements(m);
    }
}
