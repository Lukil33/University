package Piastrelle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class NormalPiastrella{
    private String code;
    private Materials material;
    private double side;
    private double price;
    private Color background;
    private boolean changableColor;
    public NormalPiastrella(String code, double side, double price, Materials material, boolean cc){
        this.code = code;
        this.side = side;
        this.price = price;
        this.material = material;
        this.changableColor = cc;
        setStartingColor();
    }
    private void setStartingColor(){this.background = Color.BROWN;}
    public String getCode(){return this.code;}
    public double getSide(){return this.side;}
    public double getPrice(){return this.price;}
    public String getMaterial(){return this.material.toString();}
    public boolean getChangableColor(){return this.changableColor;}
    public Color getColor(){return this.background;}
    public void changeBackgroundColor(){
        this.background = changeColor(background);
    }
    protected Color changeColor(Color o){
        if(o.equals(Color.BROWN)){
            return Color.WHEAT;
        }else if(o.equals(Color.WHEAT)){
            return Color.TEAL;
        }else if(o.equals(Color.TEAL)){
            return Color.DARKBLUE;
        }else if(o.equals(Color.DARKBLUE)){
            return Color.OLIVE;
        }else if(o.equals(Color.OLIVE)){
            return Color.GOLD;
        }else{
            return Color.BROWN;
        }
    }
}
