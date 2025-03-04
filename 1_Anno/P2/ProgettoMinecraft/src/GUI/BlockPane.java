package GUI;

import Blocchi.Block.Factory;
import Blocchi.Interfacce.Block;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class BlockPane extends StackPane{
    private Rectangle sfondo;
    private Text testo;
    protected Block blocco;
    public static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 18;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final Color BLOCK_BORDER = Color.BLACK;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = Color.BLACK;
    public BlockPane(Block b){
        this.blocco = b;
        initialize();
    }
    private void initialize(){
        sfondo = new Rectangle(DIM_SQUARE, DIM_SQUARE);
        testo = new Text();

        testo.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
        testo.setText(""+this.blocco.display());
        testo.setFill(FONT_FILL);
        testo.setStroke(FONT_BORDER);
        sfondo.setStroke(BLOCK_BORDER);
        sfondo.setFill(Factory.setColor(blocco));

        super.getChildren().addAll(sfondo, testo);
        super.setAlignment(Pos.CENTER);
    }
    public void changeBlock(Block b){
        this.blocco = b;
        initialize();
    }
}