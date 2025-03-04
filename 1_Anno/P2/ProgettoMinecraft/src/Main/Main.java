package Main;
import Controller.MainSimpleController;
import GUI.MainGui;
import InterfacciaUtente.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        MainSimpleController mc = new MainSimpleController(new MainView());
        MainGui layout = mc.mg;
        Scene scena = new Scene(layout,900,520);
        stage.setScene(scena);
        stage.show();
    }
}