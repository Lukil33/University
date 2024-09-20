
import Utility.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        Controller c = new Controller();
        Scene scene = new Scene(c.gui);
        primaryStage.setScene(scene);
        primaryStage.setHeight(260);
        primaryStage.setWidth(260);
        primaryStage.show();
    }
}