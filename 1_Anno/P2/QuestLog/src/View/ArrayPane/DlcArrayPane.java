package View.ArrayPane;

import Quest.DlcQuest;
import Quest.MainQuest;
import Utility.Comparator.NameComp;
import Utility.Comparator.RicompComp;
import Utility.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class DlcArrayPane extends VBox{
    public DlcArrayPane(Controller c){
        super(5);
        ArrayList<DlcQuest> dlq = c.getDlcList();
        for(MainQuest o:dlq){
            VBox quest = new VBox();
            QuestPane qp = new QuestPane(o);
            Button completa = new Button("Completa");
            completa.setOnAction((ActionEvent e) -> c.completeQuest(o));
            quest.setAlignment(Pos.CENTER);
            quest.getChildren().addAll(qp,completa);
            this.getChildren().add(quest);
        }

        Button nome = new Button("Ordina per Nome");
        nome.setOnAction((ActionEvent e) -> c.setDlcComparator(new NameComp()));
        Button ricompensa = new Button("Ordina per Ricompensa");
        ricompensa.setOnAction((ActionEvent e) -> c.setDlcComparator(new RicompComp()));

        this.getChildren().addAll(nome,ricompensa);
        this.setAlignment(Pos.TOP_CENTER);
    }
}
