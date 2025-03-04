package View.Header;

import Movies.Anime;
import Movies.Film;
import Movies.SerieTv;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class StackCell extends StackPane{
    private Film mov;
    StackCell(Film m){
        this.mov = m;
        addBackground();
        addText();
        this.setAlignment(Pos.CENTER);
    }
    private void addBackground(){
        Rectangle sfondo = new Rectangle(130,40);
        sfondo.setFill(mov.getColor());
        this.getChildren().add(sfondo);
    }
    private void addText(){
        Text testo = new Text(mov.getTitle() + " ('" + mov.getYear()%100 + ")");
        this.getChildren().add(testo);
    }
}
