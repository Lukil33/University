package View;

import Exceptions.ValTooHigh;
import Exceptions.ValTooLow;
import Utility.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class ButtonPane extends HBox implements EventHandler<ActionEvent>{
    private int number;
    private final Controller control;
    ButtonPane(Controller c){
        this.number = 0;
        this.control = c;
        redraw();
    }
    private void redraw(){
        this.getChildren().clear();

        Button numero = new Button("" + (number + 1));
        numero.setOnAction(this);

        Button riga = new Button("Cambia riga");
        riga.setOnAction((ActionEvent e) -> control.changeRow(number));

        Button colonna = new Button("Cambia colonna");
        colonna.setOnAction((ActionEvent e) -> control.changeCol(number));

        this.getChildren().addAll(numero,riga,colonna);
    }
    void finalRedraw(){
        this.getChildren().clear();

        Button numero = new Button("" + (number + 1));
        numero.setOnAction((ActionEvent e) -> {changeNumber(); finalRedraw();});

        Button riga = new Button("Cambia riga");

        Button colonna = new Button("Cambia colonna");

        this.getChildren().addAll(numero,riga,colonna);
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.changeNumber();
        this.redraw();
    }
    private void changeNumber(){
        this.number += 1;
        try {
            check();
        }catch(ValTooHigh v){
            this.number = 0;
        }
    }
    private void check() throws ValTooHigh{
        if(number > 3){
            throw new ValTooHigh();
        }
    }
}
