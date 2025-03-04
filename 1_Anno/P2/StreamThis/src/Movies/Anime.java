package Movies;

import javafx.scene.paint.Color;

public class Anime extends Film{
    private String subtiles;
    public Anime(String t, int y, String l, String sub, double c) {
        super(t,y,l,c);
        this.subtiles = sub;
    }
    public String getSubtiles(){return this.subtiles;}
    public Color getColor(){return Color.SALMON;}
}
