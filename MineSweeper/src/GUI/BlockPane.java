package GUI;

import Blocks.Block;
import Blocks.Cell;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Objects;


public class BlockPane extends StackPane{
    protected Block b;
    private Rectangle sfondo;
    private static final Color STROKE = Color.GRAY;
    private final int DIMCELL;
    private int FONT_DIM;
    private static final String FONT_NAME = "Verdana";
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    public BlockPane(int dim){
        this.DIMCELL = dim;
        initialBackground();

    }
    public BlockPane(int dim, int font, Block block){
        this.DIMCELL = dim;
        this.FONT_DIM = font;
        this.b = block;
        if(b.getDiscovered()){
            discoveredBackgroud();
            if(!Objects.equals(b.getName(), "0")){
                insertName();
            }
        }else{
            initialBackground();
            if(b.isFlagged()){
                insertFlag();
            }
        }
    }
    private void insertFlag(){
        Text flag = new Text("▶");
        flag.setFont(Font.font(FONT_NAME,FONT_WEIGHT,FONT_DIM));
        flag.setFill(Color.RED);
        this.getChildren().add(flag);
        this.setAlignment(Pos.TOP_CENTER);
    }
    private void insertName(){
        Text name = new Text(b.getName());
        name.setFont(Font.font(FONT_NAME,FONT_WEIGHT,FONT_DIM));
        if(b.isExplosive()){
            name.setFill(Color.BLACK);
        }else{
            name.setFill(setColor());
        }
        this.getChildren().add(name);
        this.setAlignment(Pos.CENTER);
    }
    private Color setColor(){
        Cell c = (Cell) this.b;
        return switch (c.getVal()){
            case 1 -> Color.BLUE;
            case 2 -> Color.GREEN;
            case 3 -> Color.RED;
            case 4 -> Color.PURPLE;
            case 5 -> Color.ORANGE;
            case 6 -> Color.CYAN;
            case 7 -> Color.BROWN;
            default -> Color.BLACK;
        };
    }
    private void initialBackground(){
        insertBackground(Color.GRAY);
    }
    private void discoveredBackgroud(){
        insertBackground(Color.GAINSBORO);
    }
    private void insertBackground(Color c){
        sfondo = new Rectangle(DIMCELL,DIMCELL);
        sfondo.setFill(c);
        sfondo.setStroke(STROKE);
        this.getChildren().add(sfondo);
    }
}
