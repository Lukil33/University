import Utility.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        Controller main = new Controller();
        Scene scene = new Scene(main.getGui());
        primaryStage.setScene(scene);
        primaryStage.setWidth(460);
        primaryStage.setHeight(250);
        primaryStage.show();
    }
}