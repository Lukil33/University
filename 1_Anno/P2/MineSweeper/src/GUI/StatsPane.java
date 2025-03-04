package GUI;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StatsPane extends HBox{
    private int numFlag;
    private static final String FONT_NAME = "Verdana";
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final int FONT_DIM = 20;
    public StatsPane(int nf){
        this.numFlag = nf;
        redraw();
    }
    public void redraw(){
        this.getChildren().clear();
        Text num = new Text(""+numFlag);
        num.setFont(Font.font(FONT_NAME,FONT_WEIGHT,FONT_DIM));
        num.setFill(Color.RED);
        Text testo = new Text("Bandiere rimanenti: ");
        testo.setFont(Font.font(FONT_NAME,FONT_WEIGHT,FONT_DIM));
        this.getChildren().addAll(testo,num);
        this.setAlignment(Pos.CENTER);
    }
    public void addFlag(){
        this.numFlag -= 1;
    }
    public void remFlag(){
        this.numFlag += 1;
    }
    public void deafeat(){
        this.getChildren().clear();
        Text testo = new Text("SKADOOSH, sei morto");
        testo.setFont(Font.font(FONT_NAME,FONT_WEIGHT,FONT_DIM));
        this.getChildren().add(testo);
        this.setAlignment(Pos.CENTER);
    }
    public void victory(){
        this.getChildren().clear();
        Text testo = new Text("Complimenti, hai vinto");
        testo.setFont(Font.font(FONT_NAME,FONT_WEIGHT,FONT_DIM));
        this.getChildren().add(testo);
        this.setAlignment(Pos.CENTER);
    }
}
