package Controller;

import GUI.*;
import GUI.Clickable.Intern;
import InterfacciaUtente.Furnace;

public class FurnaceSimpleController implements SimpleController{
    private final Furnace f;
    public final FurnacePane pane;
    public FurnaceSimpleController(Furnace forno, FurnacePane p){
        this.f = forno;
        this.pane = p;
        redraw();
    }
    @Override
    public void redraw(){
        pane.removeElements();
        pane.setInput(new Intern(f.watchInput()));
        pane.setOutput(new Intern(f.watchOutput()));
        pane.addElements();
    }
}
