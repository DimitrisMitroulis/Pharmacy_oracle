package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller {
    public static String rId = "hello";
    @FXML
    Button Login,Sign_up;
    @FXML
    TextField idTxt;
    @FXML
    PasswordField PasswordTxt;
    @FXML
    Label label1;


    public void Sign_upOnAction() {

        try {
            //get username and password from text fields
            String idStr = idTxt.getText();
            String passwordStr = PasswordTxt.getText();

            //check if either is emty
            if (idStr.isEmpty() == false || passwordStr.isEmpty() == false) {

            //create connection
                Connection connection = DBConnector.getConnection();
            label1.setText("Connected to Oracle Database");
            System.out.println("Connected to Oracle Database");

            String sql = "insert into employee(eid,epass) " +
                    "values(?,?)";


            String dropTable = "drop table students";

            String create = "create table students(" +
                        "Stid number," +
                        "Fname varchar2(20) ," +
                        "email varchar2(20))";

                //create prepared Statement and insert username and password from text fields into database
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, idStr);
                statement.setString(2, passwordStr);

                //if row succesfully added
                int rows = statement.executeUpdate();
                if (rows > 0) {
                    label1.setText("Succesfully signed up!");
                }

                //close statement,connection
                statement.close();
                connection.close();


            }
            else{label1.setText("You need to input valid data"); }

        } catch (
                SQLException e) {
            System.out.println("Unsuccessful connection");
            e.printStackTrace();
        } }

    public void LoginOnAction() throws Exception{

        try {
            //get username and password from textfields
            String idStr = idTxt.getText();
            String passwordStr = PasswordTxt.getText();

            //check if either username or password is emty
            if (idStr.isEmpty() == false || passwordStr.isEmpty() == false) {

                //create connection
                Connection connection = DBConnector.getConnection();
                System.out.println("Connected to Oracle Database");

                String sql = "insert into students(fname,password) " +
                        "values(?,?)";


                String dropTable = "drop table students";

                String create = "create table students(" +
                        "Stid number," +
                        "Fname varchar2(20) ," +
                        "email varchar2(20))";

                //run select command with fname and password from user input
                String select = "Select * from employee where eid = '" + idStr + "' and epass = '" + passwordStr + "' ";

                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(select);
                //check if result set has at least one row,if yes succesefully authenitcated
                int count = 0;
                if (result.next()==true){
                    count++;


                    rId = result.getString("eid");
                    String Rpassword = result.getString("epass");

                    System.out.println(rId + " " + Rpassword);

                    label1.setText("User found,Logging in");

                    statement.close();
                    connection.close();
                    System.out.println("Connection closed");

                    //change screen to Main_screen.fxml
                    Parent root = FXMLLoader.load(getClass().getResource("Manager_MainScreen.fxml"));
                    Stage window = (Stage)Login.getScene().getWindow();
                    window.centerOnScreen();
                    window.setScene(new Scene (root,1300,800));
                    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                    window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
                    window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);



                }else{
                    System.out.println("Array is empty");
                        //label1.setText("Username or password is false");
                        AlertBox.display("Warning","Username or password is incorrect");

                }

            }

        } catch (
                SQLException e) {
            System.out.println("Unsuccessful connection");
            e.printStackTrace();
        } }



}


