package View;

import Piastrelle.BicolorPiastrella;
import Piastrelle.NormalPiastrella;
import Utility.Controller;
import javafx.geometry.Pos;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class MainGui extends TilePane{
    private final Controller controller;
    private InformationPane ipane;
    private ButtonPane bpane;
    private PiastrellaPane ppane;
    public MainGui(Controller c){
        this.controller = c;
        redraw();
    }
    public void redraw(){
        this.getChildren().clear();

        VBox sinistra = new VBox();
        redrawInformation();
        redrawButton();
        sinistra.getChildren().addAll(this.ipane,this.bpane);
        sinistra.setAlignment(Pos.CENTER_LEFT);

        redrawPiastrella();

        this.getChildren().add(sinistra);
        this.getChildren().add(ppane);
        this.setAlignment(Pos.CENTER);
    }
    private void redrawInformation(){
        this.ipane = new InformationPane(this.controller.getPiastrella());
    }
    private void redrawButton(){
        this.bpane = new ButtonPane(this.controller);
    }
    private void redrawPiastrella(){
        NormalPiastrella np = this.controller.getPiastrella();
        if(np instanceof BicolorPiastrella){
            this.ppane = new PiastrellaPane((BicolorPiastrella) np);
        }else{
            this.ppane = new PiastrellaPane(np);
        }
    }
}
