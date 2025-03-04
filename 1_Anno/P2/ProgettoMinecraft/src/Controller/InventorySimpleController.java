package Controller;

import GUI.InventoryPane;
import InterfacciaUtente.Inventory;

public class InventorySimpleController implements SimpleController{
    private final Inventory i;
    public final InventoryPane pane;
    public InventorySimpleController(Inventory inventario, InventoryPane p){
        this.i = inventario;
        this.pane = p;
        redraw();
    }
    @Override
    public void redraw() {
        pane.removeElements();
        pane.addElements(i);
    }
}
