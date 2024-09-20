package View.Center;

import Movies.Anime;
import Movies.Film;
import Movies.SerieTv;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InformationPane extends VBox{
    private final Film mov;
    private double totalCost;
    private int buttonPressed = 0;
    private Button prezzo;
    public InformationPane(Film m){
        this.mov = m;
        create();
        if(mov instanceof SerieTv){
            totalCost = 0;
            addSeasons();
        }else{
            totalCost = mov.getPrice();
        }
        finalPrice();
        this.setAlignment(Pos.CENTER);
    }
    private void create(){
        clear();
        Text nome = new Text("Titolo: "+mov.getTitle());
        Text anno = new Text("Anno: "+mov.getYear());
        Text lingua = new Text("Lingua: "+mov.getLanguage());
        this.getChildren().addAll(nome,anno,lingua);

        if(mov instanceof Anime){
            Text sub = new Text("Sottotitoli: "+((Anime)mov).getSubtiles());
            this.getChildren().add(sub);
        }

        Text t = new Text("Prezzo base: "+mov.getPrice());
        this.getChildren().add(t);
    }
    private void addSeasons(){
        HBox season = new HBox();
        for(int i=0; i<((SerieTv) mov).getNumSeason(); i++){
            SeasonButton b = new SeasonButton(i);
            b.addEventHandler(ActionEvent.ACTION, (ActionEvent e)->{
                if(b.isActive()){
                    b.deactive(); totalCost += mov.getPrice(); buttonPressed+=1; redraw();
                }
            });
            season.getChildren().add(b);
        }
        season.setAlignment(Pos.CENTER);
        this.getChildren().add(season);
    }
    private void finalPrice(){
        double price = totalCost;
        if(mov.getYear() < 2015){
            price -= price/10;
        }
        if(mov instanceof SerieTv && buttonPressed == ((SerieTv)mov).getNumSeason()){
            price -= price/2;
        }else if(buttonPressed >= 2){
            price -= price/4;
        }
        this.prezzo = new Button("Acquista: "+price);
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Errore di connessione");
        a.setContentText("connessione non presente.");
        prezzo.addEventHandler(ActionEvent.ACTION, (ActionEvent e)->a.showAndWait());
        this.getChildren().add(prezzo);
    }
    private void redraw(){
        this.getChildren().remove(prezzo);
        finalPrice();
    }
    public void clear(){
        this.getChildren().clear();
    }
}