package View;

import Piastrelle.NormalPiastrella;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InformationPane extends VBox{
    InformationPane(NormalPiastrella np){
        Text codice = new Text("Codice: "+np.getCode());
        Text mat = new Text("materiale: "+np.getMaterial());
        Text cost = new Text("costo: "+np.getPrice()+" EUR");
        Text dim = new Text("dimensione: "+np.getSide()+" cm");
        Text color = new Text("Scelta Colore: "+multipleColors(np)+"\n");

        this.getChildren().addAll(codice,mat,cost,dim,color);
    }
    private String multipleColors(NormalPiastrella np){
        if(np.getChangableColor()){
            return "SI";
        }else{
            return "NO";
        }
    }
}
