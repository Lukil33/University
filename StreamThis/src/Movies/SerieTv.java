package Movies;

import javafx.scene.paint.Color;

public class SerieTv extends Film{
    private int num_season;
    public SerieTv(String t, int y, String l, int num, double c) {
        super(t,y,l,c);
        this.num_season = num;
    }
    public int getNumSeason(){return this.num_season;}
    public Color getColor(){return Color.MAGENTA;}
}
