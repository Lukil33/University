package Controller;

import GUI.MainGui;
import InterfacciaUtente.Coordinate;
import InterfacciaUtente.MainView;

import java.util.Collection;

public class MainSimpleController implements SimpleController{
    private final MainView mv;
    public final MainGui mg;
    private Collection<SimpleController> collection;
    private FurnaceSimpleController fc;
    private InventorySimpleController ic;
    private MapSimpleController mc;
    public MainSimpleController(MainView mainw){
        this.mv = mainw;
        this.mg = new MainGui(this);

        mc = new MapSimpleController(mv.general_map, mg.gmap);
        fc = new FurnaceSimpleController(mv.fornace, mg.gfurnace);
        ic = new InventorySimpleController(mv.inventario, mg.ginventory);

        this.redraw();
    }
    public void smelt(){
        mv.smelt();
        fc.redraw();
    }
    public void move_finput_into_inventory(){
        mv.takeInputFromFurnace();
        ic.redraw();
        fc.redraw();
    }
    public void move_foutput_into_inventory(){
        mv.moveIntoInventoryFromFurnace();
        ic.redraw();
        fc.redraw();
    }
    public void move_into_furnace_from_inventory(int x){
        mv.moveIntoFurnaceFromInventory(x);
        ic.redraw();
        fc.redraw();
    }
    public void pick_up_block(Coordinate c){
        mv.pickUpBlock(c);
        mc.redraw();
        ic.redraw();
    }
    public void change_inventory_comparator(){
        mv.changeInventoryComparator();
        ic.redraw();
    }
    public void add_block(){
        mc.m.insert_random_block();
        mc.redraw();
    }
    public void add_ten_block(){
        for(int i=0; i<10; i++){
            mc.m.insert_random_block();
        }
        mc.redraw();
    }
    @Override
    public void redraw() {
        mc.redraw();
        fc.redraw();
        ic.redraw();
    }
}
