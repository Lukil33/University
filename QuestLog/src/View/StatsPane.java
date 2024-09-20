package View;

import Utility.PlayerStats;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class StatsPane extends HBox{
    private final PlayerStats stats;
    StatsPane(PlayerStats s){
        this.stats = s;
        redraw();
    }
    void redraw(){
        this.getChildren().clear();
        Text name = new Text(stats.getName() + ". ");
        Text level = new Text("LV:" + stats.getLevel() + " ");
        Text money = new Text("GP:" + stats.getMoney());
        this.getChildren().addAll(name,level,money);
        this.setAlignment(Pos.CENTER_LEFT);
    }
}
