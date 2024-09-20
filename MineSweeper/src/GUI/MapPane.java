package GUI;

import Blocks.Block;
import Utility.Controller;
import Utility.Coord;
import Utility.Map;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class MapPane extends GridPane{
    private Controller controller;
    private int DIM;
    private int dimCell;
    private int dimText;
    public MapPane(Controller c){
        this.controller = c;
        this.DIM = c.dimMap;
        this.dimCell = c.dimCell;
        this.dimText = c.dimText;
        drawFirstTime();
        this.setAlignment(Pos.CENTER);
    }
    private void drawFirstTime(){
        for(int x=0; x < DIM; x++){
            for(int y=0; y < DIM;y++){
                BlockPane b = new BlockPane(dimCell);
                int X = y;
                int Y = x;
                b.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {controller.startTheGame(new Coord(X,Y));});
                this.add(b,x,y);
            }
        }
    }
    public void redraw(Map m){
        mapRedraw(m);
        insertEventHandler();
    }
    public void mapRedraw(Map m){
        this.getChildren().clear();
        for(int x=0; x<DIM; x++){
            for(int y=0; y<DIM; y++){
                BlockPane bp = new BlockPane(dimCell,dimText,m.getElement(new Coord(x,y)));
                this.add(bp,y,x);
            }
        }
    }
    private void insertEventHandler(){
        for(Node c : this.getChildren()){
            BlockPane bp = (BlockPane) c;
            int X = GridPane.getRowIndex(bp);
            int Y = GridPane.getColumnIndex(bp);
            if(!(bp.b.getDiscovered())){
                bp.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                    if(e.getButton() == MouseButton.SECONDARY){
                        controller.changeFlag(new Coord(X,Y));

                        controller.gui.redraw();
                    }
                });
            }
            if(!(bp.b.isFlagged())){
                bp.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                    if(e.getButton() == MouseButton.PRIMARY){
                        controller.discover(new Coord(X,Y));
                    }
                });
            }
        }
    }
}