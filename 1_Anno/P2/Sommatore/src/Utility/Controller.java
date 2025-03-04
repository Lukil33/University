package Utility;

import Celle.AbsCell;
import Exceptions.*;
import View.MainGui;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller{
    private final Map map;
    private final Array array;
    private final MainGui gui;
    public Controller(){
        this.map = new Map();
        this.array = new Array(map);
        this.gui = new MainGui(this);
        check();
    }
    public void changeRow(int i){
        this.map.changeRow(i);
        this.array.modifySinglGreenValue(i);
        this.array.modifyAllRedValue();
        check();
        this.gui.mapRedraw();
    }
    public void changeCol(int i){
        this.map.changeCol(i);
        this.array.modifySinglRedValue(i);
        this.array.modifyAllGreenValue();
        check();
        this.gui.mapRedraw();
    }
    private void check(){
        Text messaggio = new Text();
        boolean isFinito = false;
        try{
            this.array.check();
        }catch(Win w){
            messaggio = new Text("Complimenti, hai Vinto");
            messaggio.setFill(Color.GREEN);
            isFinito = true;
        }catch(Draw d){
            messaggio = new Text("Hai Pareggiato");
            messaggio.setFill(Color.DARKGRAY);
            isFinito = true;
        }catch(Lose l){
            messaggio = new Text("Peccato, hai Perso");
            messaggio.setFill(Color.RED);
            isFinito = true;
        }
        if(isFinito){
            messaggio.setTranslateY(20);
            messaggio.setFont(new Font(20));
            Group g = new Group(messaggio);
            Scene s = new Scene(g);
            Stage stage = new Stage();
            stage.setTitle("Game Over");
            stage.setScene(s);
            stage.sizeToScene();
            stage.show();
            this.gui.finalButtonRedraw();
        }
    }
    public AbsCell getCell(int x, int y){
        if(x == this.map.getDimMappa()){
            return this.array.getRedCell(y);
        }else if(y == this.map.getDimMappa()){
            return this.array.getGreenCell(x);
        }else{
            return this.map.getCell(x,y);
        }
    }
    public int getDimMappa(){
        return this.map.getDimMappa();
    }
    public MainGui getGui(){
        return this.gui;
    }
}
