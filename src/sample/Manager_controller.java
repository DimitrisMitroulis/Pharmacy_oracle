package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class Manager_controller {

@FXML
private BorderPane mainPane;
@FXML
Button Notifications_btn,Customer_btn,Products_btn,Email_btn,Movies_btn1;


    public void loadNotifications() throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Notifications_screen");
        mainPane.setCenter(view);
    }

    public void loadCustomers()throws IOException{
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Main_screen");
        mainPane.setCenter(view);
    }

    public void loadProducts()throws IOException{
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Farmaka");
        mainPane.setCenter(view);
    }

    public void loadEmail()throws IOException{
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Email_screen");
        mainPane.setCenter(view);
    }
    public void loadMovies()throws IOException{
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ViewMovies");
        mainPane.setCenter(view);
    }
}
