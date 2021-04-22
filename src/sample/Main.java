package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        //Parent root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
        //window.setScene(new Scene(root,730,450));

        Parent root = FXMLLoader.load(getClass().getResource("Manager_MainScreen.fxml"));
        window.setScene(new Scene(root,1400,850));

        //Parent root = FXMLLoader.load(getClass().getResource("Manager_MainScreen.fxml"));
        //window.setScene(new Scene(root,730,450));

        //Parent root = FXMLLoader.load(getClass().getResource("Manager_MainScreen.fxml"));
        //window.setScene(new Scene(root,730,450));

        //Parent root = FXMLLoader.load(getClass().getResource("Manager_MainScreen.fxml"));
        //window.setScene(new Scene(root,730,450));

        Image image = new Image("Icons/LOGO.jpg");
        primaryStage.getIcons().add(image);
        window.setTitle("PHARMASTORAGE");
        window.centerOnScreen();
        window.show();
        root.getStylesheets().add("MainStyle.css");

    }


}
