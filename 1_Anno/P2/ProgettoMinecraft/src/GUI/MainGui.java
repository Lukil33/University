package GUI;

import Blocchi.Block.*;
import Controller.FurnaceSimpleController;
import Controller.InventorySimpleController;
import Controller.MainSimpleController;
import Controller.MapSimpleController;
import InterfacciaUtente.*;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane{
    public MapPane gmap;
    public ButtonListPane gbutton;
    public FurnacePane gfurnace;
    public InventoryPane ginventory;
    private MainSimpleController controller;
    public MainGui(MainSimpleController mc){
        super();
        controller = mc;
        gmap = new MapPane();
        gbutton = new ButtonListPane(controller);
        gfurnace = new FurnacePane();
        ginventory = new InventoryPane();
        EventHandler<KeyEvent> s = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCharacter().equals("s")){
                    controller.change_inventory_comparator();
                }
                if(e.getCharacter().equals("n")){
                    controller.add_block();
                }
                if(e.getCharacter().equals("r")){
                    controller.add_ten_block();
                }
            }
        };
        this.addEventHandler(KeyEvent.KEY_TYPED,s);
        this.setOnKeyPressed((KeyEvent e) -> {if(e.getCharacter().equals("s")){controller.change_inventory_comparator();}});
        super.setCenter(gmap);
        super.setLeft(gbutton);
        super.setRight(gfurnace);
        super.setBottom(ginventory);
    }
}
