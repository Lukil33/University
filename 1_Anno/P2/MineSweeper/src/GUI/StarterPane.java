package GUI;

import Utility.Controller;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class StarterPane extends VBox{
    private Controller controller;
    private static final String FONT_NAME = "Verdana";
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    public StarterPane(Controller c, int MAXMAPDIM){
        this.controller = c;
        Text choose = new Text("Seleziona la difficoltà:");
        choose.setFont(Font.font(FONT_NAME, FONT_WEIGHT, 25));

        TilePane rectangle = new TilePane();
        rectangle.setHgap(25);
        rectangle.setAlignment(Pos.CENTER);
        rectangle.getChildren().add(startCell(MAXMAPDIM/3,20,Color.GREEN,"Easy"));
        rectangle.getChildren().add(startCell((MAXMAPDIM/3)*2,100,Color.YELLOW,"Medium"));
        rectangle.getChildren().add(startCell(MAXMAPDIM,270,Color.RED,"Hard"));

        this.getChildren().addAll(choose,rectangle);
        this.setAlignment(Pos.CENTER);
    }
    private VBox startCell(int dim, int bomb, Color c, String difficulty){
        VBox cell = new VBox();
        Text t = new Text(difficulty);
        t.setFont(Font.font(FONT_NAME, FONT_WEIGHT, 15));
        cell.getChildren().addAll(starterBlock(dim,bomb,c),t);
        cell.setAlignment(Pos.CENTER);
        return cell;
    }
    private StackPane starterBlock(int dim, int bomb, Color c){
        Rectangle sfondo = new Rectangle(50,50);
        sfondo.setFill(c);
        sfondo.setStroke(Color.BLACK);

        Text dimensione = new Text(dim + " x " + dim);
        Text bombe = new Text("" + bomb);
        dimensione.setFont(Font.font(FONT_NAME, FONT_WEIGHT, 10));
        bombe.setFont(Font.font(FONT_NAME, FONT_WEIGHT, 10));

        VBox dentro = new VBox();
        dentro.getChildren().addAll(dimensione,bombe);
        dentro.setAlignment(Pos.CENTER);

        StackPane pane = new StackPane();
        pane.getChildren().addAll(sfondo, dentro);
        pane.setAlignment(Pos.CENTER);
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {controller.setStarter(dim,bomb);});
        return pane;
    }
}
