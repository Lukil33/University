package View.Evocation;

import Evocazioni.Evocation;
import Evocazioni.SupremeEvocation;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class EvocationPane extends StackPane{
    private Evocation evoc;
    EvocationPane(Evocation e){
        this.evoc = e;
        Rectangle background = new Rectangle(100,100);
        customizeBackground(background);
        Text testo= new Text();
        customizeText(testo);
        this.getChildren().addAll(background, testo);
    }
    private void customizeBackground(Rectangle b){
        b.setFill(evoc.getColor());
        if(evoc instanceof SupremeEvocation){
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(5);
        }
    }
    private void customizeText(Text t){
        t.setText(evoc.getName() + "\n"
                + evoc.getLifePoint() + "/" + evoc.getInitialLifePoint() + " PV\n"
                + "Energie: " + evoc.getAttackEnergieAttive() + "\n"
                + evoc.getAttackName() + "(" + evoc.getAttackEnergie() + ")" + "\n"
                + evoc.getAttackDanni() + " Danni");
    }
}
