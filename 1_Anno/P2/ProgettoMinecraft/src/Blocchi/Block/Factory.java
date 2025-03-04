package Blocchi.Block;

import Blocchi.Interfacce.Block;
import javafx.scene.paint.Color;

public class Factory{
    public static AirBlock airBlock(){
        return new AirBlock();
    }
    public static GlassBlock glassBlock(){
        return new GlassBlock();
    }
    public static NullBlock nullBlock(){
        return new NullBlock();
    }
    public static RawIronBlock rawIronBlock(){
        return new RawIronBlock();
    }
    public static SandBlock sandBlock(){
        return new SandBlock();
    }
    public static WaterBlock waterBlock(){
        return new WaterBlock();
    }
    public static TorchBlock torchBlock(){return new TorchBlock();}
    public static Color setColor(Block b){
        String carattere = b.toString();
        return switch (carattere) {
            case "Air" -> Color.rgb(150, 200, 200);
            case "Glass" -> Color.rgb(50, 200, 170);
            case "Iron Sword" -> Color.rgb(145, 145, 145);
            case "Raw Iron" -> Color.rgb(56, 56, 56);
            case "Sand" -> Color.rgb(255, 190, 0);
            case "Torch" -> Color.rgb(100, 50, 0);
            case "Water" -> Color.rgb(60, 120, 210);
            default -> Color.WHITE;
        };
    }
}
