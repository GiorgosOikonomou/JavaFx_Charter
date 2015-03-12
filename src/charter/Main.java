package charter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.midi.ControllerEventListener;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controler=new Controller(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
