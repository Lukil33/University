package GUI;

import Utility.Controller;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MainGui extends BorderPane{
    private Controller c;
    public StatsPane stats;
    private MapPane pane;
    public MainGui(Controller contr){
        this.c = contr;
        this.stats = new StatsPane(c.moves);
        this.pane = new MapPane(c);
        this.setTop(stats);
        stats.setAlignment(Pos.CENTER);
        this.setCenter(pane);
    }
    public void mapRedraw(){
        pane.redraw(c.m);
    }
}
