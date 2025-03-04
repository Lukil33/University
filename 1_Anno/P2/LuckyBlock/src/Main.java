import Utility.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller c = new Controller(10);
        Scene scene = new Scene(c.gui);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}