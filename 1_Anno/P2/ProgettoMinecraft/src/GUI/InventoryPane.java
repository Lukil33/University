package GUI;

import Blocchi.Interfacce.Block;
import Controller.MainSimpleController;
import GUI.Clickable.Anonimous;
import InterfacciaUtente.Inventory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InventoryPane extends HBox{
    private final Text testo = new Text("Inventory:");
    private HBox blocchi;
    public InventoryPane(){
        super();
        testo.setFont(Font.font("Verdana", FontWeight.BLACK,11));
        blocchi = new HBox();
        addElements(new Inventory());
    }
    public void removeElements(){
        this.blocchi.getChildren().clear();
        this.getChildren().clear();
    }
    public void addElements(Inventory i){
        for(Block e:i.inventario){
            addBlock(e, i);
        }
        this.getChildren().addAll(testo,blocchi);
    }
    public void addBlock(Block b, Inventory i){
        blocchi.getChildren().add(new Anonimous(b, i));
    }
}