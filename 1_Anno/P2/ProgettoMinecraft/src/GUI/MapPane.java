package GUI;

import Blocchi.Block.Factory;
import Blocchi.Interfacce.Block;
import Controller.MainSimpleController;
import Controller.MapSimpleController;
import GUI.Clickable.Anonimous;
import GUI.Clickable.Extern;
import InterfacciaUtente.Coordinate;
import InterfacciaUtente.Map;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class MapPane extends GridPane{
    public MapPane(){
        initialise();
    }
    private void initialise(){
        for(int i=0; i< Map.getRows(); i++){
            for(int j=0; j<Map.getColumns(); j++) {
                setCell(new Coordinate(i,j), Factory.airBlock());
            }
        }
    }
    public void addElements(Map m){
        for(int i=0; i<Map.getRows(); i++){
            for(int j=0; j<Map.getColumns(); j++) {
                setCell(new Coordinate(i,j), m.get_cell(new Coordinate(i,j)));
            }
        }
    }
    public void removeElements(){
        this.getChildren().clear();
    }
    public Extern getBlockAtCoords(Coordinate c){
        return(Extern) getElementAt(this, c.getX(), c.getY());
    }
    private static Node getElementAt(GridPane gp, int i, int j) {
        for(Node x :gp. getChildren()){
            if((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }
    public void setCell(Coordinate c, Block b){
        Extern block = getBlockAtCoords(c);
        if(block == null){
            super.add(new Extern(b), c.getY(), c.getX());
        }else{
            block.changeBlock(b);
        }
    }
}
