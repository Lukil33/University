package View;

import Utility.Comparator.NameComp;
import Utility.Comparator.TypeComp;
import Utility.Comparator.YearComp;
import Utility.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class RightButtonPane extends TilePane{
    RightButtonPane(Controller c){
        Button nome = new Button("Nome");
        nome.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> c.changeComparator(new NameComp()));
        Button anno = new Button("Anno");
        anno.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> c.changeComparator(new YearComp()));
        Button tipo = new Button("Tipo");
        tipo.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> c.changeComparator(new TypeComp()));

        this.getChildren().addAll(createText(),nome,anno,tipo);
        this.setVgap(10);
        this.setPrefColumns(1);
    }
    private Text createText(){
        return new Text("Ordina per:");
    }
}
