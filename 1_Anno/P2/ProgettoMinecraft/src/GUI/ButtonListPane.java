package GUI;

import Controller.MainSimpleController;
import InterfacciaUtente.Coordinate;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ButtonListPane extends VBox{
    private final MainSimpleController controller;
    public ButtonListPane(MainSimpleController mc){
        this.controller = mc;
        take_block();
        move_into_furnace();
        smelt();
        inventory();
        toggle();
    }
    private void take_block(){
        TextField row = new TextField("0");
        TextField columns = new TextField("0");
        row.setPrefWidth(50);
        columns.setPrefWidth(50);
        Button take = new Button("Pick");
        take.addEventHandler(ActionEvent.ACTION,(ActionEvent e)->{
            controller.pick_up_block(new Coordinate(Integer.decode(row.getText()),Integer.decode(columns.getText())));
        });
        HBox riga = new HBox(row,columns,take);
        this.getChildren().addAll(riga);
    }
    private void move_into_furnace(){
        TextField element = new TextField("0");
        element.setPrefWidth(50);
        Button in_furnace = new Button("Move into Furnace");
        in_furnace.addEventHandler(ActionEvent.ACTION,(ActionEvent e)->{
            controller.move_into_furnace_from_inventory(Integer.decode(element.getText()));
        });
        HBox riga = new HBox(element,in_furnace);
        this.getChildren().addAll(riga);
    }
    private void smelt(){
        Button s = new Button("Smelt");
        s.addEventHandler(ActionEvent.ACTION, (ActionEvent e)->{controller.smelt();});
        this.getChildren().add(s);
    }
    private void inventory(){
        Button in = new Button("Take Input");
        in.addEventHandler(ActionEvent.ACTION, (ActionEvent e)->{controller.move_finput_into_inventory();});
        Button out = new Button("Take output");
        out.addEventHandler(ActionEvent.ACTION, (ActionEvent e)->{controller.move_foutput_into_inventory();});
        HBox riga = new HBox(in,out);
        this.getChildren().add(riga);
    }
    private void toggle(){
        Button o = new Button("Change order");
        o.addEventHandler(ActionEvent.ACTION, (ActionEvent e)->{controller.change_inventory_comparator();});
        this.getChildren().add(o);
    }
}