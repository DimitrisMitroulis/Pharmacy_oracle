package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Farmaka_Controlelr implements Initializable{
    @FXML
    Button Search_btn,Go_backBtn,next;
    @FXML
    TextField pid_text;
    @FXML
    Label status;
    @FXML
    private ChoiceBox<String> choiceBox;


    @FXML
    TableView<Farmaka_Table> table;
    @FXML
     TableColumn<Farmaka_Table, String> col_pid;
    @FXML
     TableColumn<Farmaka_Table, String> col_pname;
    @FXML
     TableColumn<Farmaka_Table, String> col_ptype;
    @FXML
    TableColumn<Farmaka_Table, Date> col_expdate;
    @FXML
     TableColumn<Farmaka_Table, String> col_stock;
    @FXML
     TableColumn<Farmaka_Table, String> col_koaap;
    @FXML
    TableColumn<Farmaka_Table, String> col_timessold;


    ObservableList<Farmaka_Table> oblist = FXCollections.observableArrayList();
    ObservableList choiceBoxStatus = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxStatus.removeAll(choiceBoxStatus);
        String pid = "id";
        String name = "name";
        String Type = "type";
        String Stock = "stock";
        String Koaap = "koaap";
        String timessold = "timessold";
        choiceBoxStatus.addAll(pid,name,Type,Stock,Koaap,timessold);
        choiceBox.getItems().addAll(choiceBoxStatus);
        choiceBox.setValue(pid);

        String sql = "select * from products ";

        Connection conn = null;
        try {
            conn = DBConnector.getConnection();

        Statement stmt = conn.createStatement();



            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("trying2");
                oblist.add(new Farmaka_Table(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getDate("expdate"),
                        rs.getString("stock"),
                        rs.getString("koaap"),
                        rs.getString("timessold")));
            }
            rs.close();
            stmt.close();
            conn.close();

            col_pid.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_pname.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_ptype.setCellValueFactory(new PropertyValueFactory<>("type"));
            col_expdate.setCellValueFactory(new PropertyValueFactory<>("expdate"));
            col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
            col_koaap.setCellValueFactory(new PropertyValueFactory<>("koaap"));
            col_timessold.setCellValueFactory(new PropertyValueFactory<>("timessold"));
            table.setItems(oblist);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void search() throws SQLException {
      String selected = choiceBox.getValue();
      oblist.clear();
      status.setText("");

      String pid_string = pid_text.getText();

      String sql = "select * from products where "+ selected +" = "+ "'" + pid_string + "'" ;

      Connection conn = DBConnector.getConnection();
      Statement stmt = conn.createStatement();


      if(pid_string.isEmpty() == false ){
          ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) {
              System.out.println("trying2");
              oblist.add(new Farmaka_Table(
                      rs.getString("id"),
                      rs.getString("name"),
                      rs.getString("type"),
                      rs.getDate("expdate"),
                      rs.getString("stock"),
                      rs.getString("koaap"),
                      rs.getString("timessold")));
            }
          rs.close();
          stmt.close();
          conn.close();

          col_pid.setCellValueFactory(new PropertyValueFactory<>("id"));
          col_pname.setCellValueFactory(new PropertyValueFactory<>("name"));
          col_ptype.setCellValueFactory(new PropertyValueFactory<>("type"));
          col_expdate.setCellValueFactory(new PropertyValueFactory<>("expdate"));
          col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
          col_koaap.setCellValueFactory(new PropertyValueFactory<>("koaap"));
          col_timessold.setCellValueFactory(new PropertyValueFactory<>("timessold"));
          table.setItems(oblist);
      }else{
          AlertBox.display("Warning","Please type a value to search");}


    }

    public void Go_back() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
        Stage window = (Stage)Go_backBtn.getScene().getWindow();
        window.setScene(new Scene(root,453,500));

    }

    public void nextScene () throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Notifications_screen.fxml"));
        Stage window = (Stage)Go_backBtn.getScene().getWindow();
        window.setScene(new Scene(root,453,500));

    }

}



