package GUI;

import Blocks.AbstractBlock;
import Utility.Controller;
import Utility.Map;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MapPane extends GridPane{
    private Controller c;
    public MapPane(Controller contr){
        this.c = contr;
        redraw(c.m);
    }
    public void redraw(Map m){
        this.getChildren().clear();
        for(int x=0; x<Map.DIM; x++){
            for(int y=0; y<Map.DIM; y++){
                super.add(new BlockPane(m.getBlock(x,y)),x,y);
            }
        }
        for(Node b:this.getChildren()){
            BlockPane block = (BlockPane) b;
            int x = GridPane.getColumnIndex(b);
            int y = GridPane.getRowIndex(b);
            block.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                c.discover(x, y);
            });
        }
    }
}
