package GUI;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StatsPane extends VBox{
    private Text punteggio;
    private Text mosse;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 15;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    public StatsPane(int moves){
        punteggio = new Text("");
        punteggio.setFont(Font.font(FONT_NAME,FONT_WEIGHT,FONT_SIZE));
        mosse = new Text("");
        mosse.setFont(Font.font(FONT_NAME,FONT_WEIGHT,FONT_SIZE));
        redraw(0,moves);
    }
    public void redraw(int p, int m){
        this.getChildren().clear();
        punteggio.setText("Punteggio attuale: " + p);
        this.getChildren().add(punteggio);
        mosse.setText("Mosse rimanenti: " + m);
        this.getChildren().add(mosse);
    }
    public void end(int p){
        this.getChildren().clear();
        punteggio.setText("Mosse Terminate, il punteggio finale è di: "+ p);
        this.getChildren().add(punteggio);
        mosse.setText("");
        this.getChildren().add(mosse);
    }
    public void goodend(int p){
        this.getChildren().clear();
        punteggio.setText("Hai rivelato tutte le celle, il punteggio finale è di: "+ p);
        this.getChildren().add(punteggio);
        mosse.setText("");
        this.getChildren().add(mosse);
    }
}