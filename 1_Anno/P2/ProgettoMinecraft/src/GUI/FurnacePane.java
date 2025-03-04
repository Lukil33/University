package GUI;

import Blocchi.Block.*;
import Controller.MainSimpleController;
import GUI.Clickable.Intern;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FurnacePane extends VBox{
    private final Text factory = new Text("Furnace");
    private Intern input;
    private final Text arrow = new Text("\uD83E\uDC6B");
    private Intern output;
    public FurnacePane(){
        factory.setFont(Font.font("Verdana", FontWeight.BLACK,11));
        setInput(new Intern(Factory.nullBlock()));
        arrow.setFont(Font.font("Verdana", FontWeight.BLACK,20));
        setOutput(new Intern(Factory.nullBlock()));
        this.setAlignment(Pos.TOP_CENTER);
        addElements();
    }
    public void removeElements(){
        this.getChildren().clear();
    }
    public void setInput(Intern i){
        this.input = i;
    }
    public void setOutput(Intern i){
        this.output = i;
    }
    public void addElements(){
        this.getChildren().addAll(factory,input,arrow,output);
    }
}