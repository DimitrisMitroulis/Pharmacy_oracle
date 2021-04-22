package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        window.setScene(new Scene(root,453,500));
        window.setTitle("Hello World");
        window.centerOnScreen();
        window.show();
        root.getStylesheets().add("MainStyle.css");

    }


}
