package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Notifications_controller implements Initializable {

    @FXML
    Button Go_backBtn;

    @FXML
    private TableView<NotificationTable> table;
    @FXML
    private TableColumn<NotificationTable, String> col_id;
    @FXML
    private TableColumn<NotificationTable, String> col_nsubj;
    @FXML
    private TableColumn<NotificationTable, Date> col_ndate;

    ObservableList<NotificationTable> oblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //String searchid = "select from employee where eid";
        //Get the eid of the person that logged in and keep the first number
        String searchId = Controller.rId;
        char ch1 = searchId.charAt(0);


        String sql = "select * from notifications where rolenum = " + ch1 + "";

        try {
            Connection conn = DBConnector.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("connection succesfull");

            while (rs.next()) {
                System.out.println("trying2");
                oblist.add(new NotificationTable(
                        rs.getString("nsubj"),
                        rs.getDate("ndate")));
            }

            rs.close();
            stmt.close();
            conn.close();
            System.out.println("connection closed");


            col_nsubj.setCellValueFactory(new PropertyValueFactory<>("nsubj"));
            col_ndate.setCellValueFactory(new PropertyValueFactory<>("ndate"));
            table.setItems(oblist);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void Go_back() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
        Stage window = (Stage)Go_backBtn.getScene().getWindow();
        window.setScene(new Scene(root,453,500));
    }



}
