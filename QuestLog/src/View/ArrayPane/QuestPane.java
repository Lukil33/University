package View.ArrayPane;

import Quest.*;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class QuestPane extends StackPane{
    QuestPane(AbsQuest q){
        Rectangle background = new Rectangle(240,60);
        if(q.isCompleted()){
            background.setFill(Color.LIGHTGREEN);
        }else{
            background.setFill(Color.BEIGE);
        }
        this.getChildren().add(background);
        this.setAlignment(Pos.CENTER);
    }
    public QuestPane(MainQuest mq){
        this((AbsQuest) mq);
        if(mq instanceof DlcQuest){
            Text testo = new Text(mq.getName() + " (" + mq.getRicompensa() + ")\n"
                    + "DLC Req." + ((DlcQuest)mq).getDependency());
            this.getChildren().add(testo);
        }else{
            Text testo = new Text(mq.getName() + " (" + mq.getRicompensa() + ")\n"
                    + "Luogo: " + mq.getLocation() + "\n"
                    + "Req." + prevName(mq));
            this.getChildren().add(testo);
        }
    }
    public QuestPane(SecondaryQuest sq){
        this((AbsQuest) sq);
        Text testo = new Text(sq.getName() + " (" + sq.getRicompensa() + ")\n"
                + "NPC: " +sq.getNpcName());
        this.getChildren().add(testo);
    }
    public QuestPane(ContractQuest cq){
        this((AbsQuest) cq);
        Text testo = new Text(cq.getName() + " (" + cq.getRicompensa() + ")\n"
                + "Mostri: " + cq.getMonster() + place(cq));
        this.getChildren().add(testo);
    }
    private String prevName(MainQuest mg){
        if(mg.getPrec() != null){
            return mg.getPrec().getName();
        }else{
            return "none";
        }
    }
    private String place(ContractQuest cq){
        if(cq instanceof TreasureHuntsQuest){
            return "\nLuogo: " + ((TreasureHuntsQuest) cq).getPlace();
        }else{
            return "";
        }
    }
}
