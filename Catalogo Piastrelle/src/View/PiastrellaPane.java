package View;

import Piastrelle.BicolorPiastrella;
import Piastrelle.NormalPiastrella;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class PiastrellaPane extends StackPane{
    private static final double DIM_SIDE = 130;
    private static final double DIM_INTERN = DIM_SIDE/2;
    PiastrellaPane(NormalPiastrella normp){
        backgroundRedraw(normp);
    }
    PiastrellaPane(BicolorPiastrella bicp){
        internalRedraw(bicp);
    }
    private void backgroundRedraw(NormalPiastrella normp){
        this.getChildren().clear();
        Rectangle sfondo = new Rectangle(DIM_SIDE,DIM_SIDE);
        sfondo.setFill(normp.getColor());
        sfondo.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e)->{
            if(normp.getChangableColor()){
                normp.changeBackgroundColor();
                if(normp instanceof BicolorPiastrella){
                    internalRedraw((BicolorPiastrella) normp);
                }else{
                    backgroundRedraw(normp);
                }
            }
        });
        this.getChildren().add(sfondo);
    }
    private void internalRedraw(BicolorPiastrella bicp){
        backgroundRedraw(bicp);
        Shape interno;
        if(bicp.getShape() instanceof Rectangle){interno = new Rectangle(DIM_INTERN,DIM_INTERN);}else{interno = new Circle(DIM_INTERN/2);}
        interno.setFill(bicp.getInternColor());
        interno.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e)->{
            if(bicp.getChangableColor()){
                bicp.changeIntenalColor();
                internalRedraw(bicp);
            }
        });
        this.getChildren().add(interno);
    }
}
