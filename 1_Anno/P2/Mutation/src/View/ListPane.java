package View;

import Mutation.Mutation;
import Utility.Controller;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ListPane extends VBox {
    ListPane(Controller c){
        Text mutazioni = new Text("Mutazioni Possibili:");
        GridPane griglia = new GridPane();
        int i=0;
        for(Mutation m : c.m){
            MutationPane mutBlock = new MutationPane(m);
            griglia.add(mutBlock,i,0);
            int Var = i;
            mutBlock.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> c.applyMutation(Var));
            i++;
        }
        this.getChildren().addAll(mutazioni,griglia);
    }
}
