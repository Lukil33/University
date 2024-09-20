package GUI;

import Blocks.Block;
import Blocks.Bomb;
import Blocks.Division;
import Blocks.Multiply;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BlockPane extends StackPane{
    private Text t;
    private Rectangle sfondo;
    private Block blocco;
    private static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 15;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final Color BLOCK_BORDER = Color.BLACK;
    private static final Color INITIAL_BLOCK_FILL = Color.YELLOW;
    public BlockPane(Block b){
        this.blocco = b;
        this.t = new Text(b.getString());
        this.sfondo = new Rectangle(DIM_SQUARE,DIM_SQUARE);
        sfondo.setStroke(BLOCK_BORDER);
        sfondo.setFill(INITIAL_BLOCK_FILL);
        this.getChildren().add(sfondo);
        if(b.getDiscovered()){
            redraw();
        }
    }
    public void redraw(){
        this.getChildren().clear();
        t.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
        changeSfondo();
        this.getChildren().addAll(sfondo,t);
    }
    private void changeSfondo(){
        if(this.blocco instanceof Bomb){
            sfondo.setFill(Color.BLUE);
        }else if(this.blocco instanceof Division){
            sfondo.setFill(Color.RED);
        }else if(this.blocco instanceof Multiply){
            sfondo.setFill(Color.GREEN);
        }else{
            sfondo.setFill(Color.WHITE);
        }
    }
}
