
import Utility.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        Controller c = new Controller();
        Scene scene = new Scene(c.getGui());
        primaryStage.setScene(scene);
        primaryStage.setWidth(420);
        primaryStage.show();
    }
}