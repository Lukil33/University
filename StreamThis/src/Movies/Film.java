package Movies;

import javafx.scene.paint.Color;

public class Film {
    private String title;
    private int pubYear;
    private String language;
    private double costo;
    public Film(String t, int y, String l, double c){
        this.title = t;
        this.pubYear = y;
        this.language = l;
        this.costo = c;
    }
    public String getTitle(){return this.title;}
    public int getYear(){return this.pubYear;}
    public String getLanguage(){return this.language;}
    public double getPrice(){return this.costo;}
    public Color getColor(){return Color.CYAN;}
}
