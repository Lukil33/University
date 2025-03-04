package Utility;

import Exceptions.FirstPiastrella;
import Exceptions.LastPiastrella;
import Piastrelle.BicolorPiastrella;
import Piastrelle.Materials;
import Piastrelle.NormalPiastrella;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Archivio extends ArrayList<NormalPiastrella>{
    private int selected;
    public Archivio(){
        this.selected = 0;
        initalize();
    }
    private void initalize(){
        this.add(new NormalPiastrella("P1",50,50, Materials.ceramica, false));
        this.add(new NormalPiastrella("P2",80,20, Materials.laminato, true));
        this.add(new NormalPiastrella("P3",40,50, Materials.terracotta, true));
        this.add(new BicolorPiastrella("B1",40,100, Materials.laminato, false, new Rectangle()));
        this.add(new BicolorPiastrella("B2",90,120, Materials.ceramica, true, new Circle()));
        this.add(new BicolorPiastrella("B3",50,140, Materials.terracotta, true,new Rectangle()));
    }
    NormalPiastrella getPiastrella(){
        return this.get(selected);
    }
    void changeSelected(int x){
        this.selected += x;
    }
    void firstCheck() throws FirstPiastrella{
        if(selected <= 0){
            throw new FirstPiastrella();
        }
    }
    void lastCheck() throws LastPiastrella{
        if(selected >= this.size()-1){
            throw new LastPiastrella();
        }
    }
}
