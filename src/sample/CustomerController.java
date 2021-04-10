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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Observable;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    @FXML
    Button Go_backBtn,Add_customer,Refresh_btn,DeleteBtn;
    @FXML
    TextField Textcid,Tfname,Tlname,Tcity,Tstreet,Tstnum,Tps,Temail,Tafm;
    @FXML
    Label status;

    @FXML
     TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable,String> col_cid;
    @FXML
    private TableColumn<ModelTable,String> col_Fname;
    @FXML
    private TableColumn<ModelTable,String> col_Lname;
    @FXML
    private TableColumn<ModelTable,String> col_City;
    @FXML
    private TableColumn<ModelTable,String> col_Street;
    @FXML
    private TableColumn<ModelTable,String> col_StNum;
    @FXML
    private TableColumn<ModelTable,String> col_PostCode;
    @FXML
    private TableColumn<ModelTable,String> col_Email;
    @FXML
    private TableColumn<ModelTable,String> col_Afm;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            String sql = "select * from customer";
            Connection conn = DBConnector.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("connected to database");
            while (rs.next()) {
                System.out.println("trying");
                oblist.add(new ModelTable(
                        rs.getString("cid"),
                        rs.getString("cfname"),
                        rs.getString("clname"),
                        rs.getString("city"),
                        rs.getString("street"),
                        rs.getString("stnumber"),
                        rs.getString("postalcode"),
                        rs.getString("cemail"),
                        rs.getString("cafm")));

            }
            rs.close();
            stmt.close();

            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        col_cid.setCellValueFactory(new PropertyValueFactory<>("cid"));
        col_Fname.setCellValueFactory(new PropertyValueFactory<>("cfname"));
        col_Lname.setCellValueFactory(new PropertyValueFactory<>("clname"));
        col_City.setCellValueFactory(new PropertyValueFactory<>("city"));
        col_Street.setCellValueFactory(new PropertyValueFactory<>("street"));
        col_StNum.setCellValueFactory(new PropertyValueFactory<>("stnumber"));
        col_PostCode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));
        col_Email.setCellValueFactory(new PropertyValueFactory<>("cemail"));
        col_Afm.setCellValueFactory(new PropertyValueFactory<>("cafm"));




            table.setItems(oblist);
    }

    public void Refresh() throws SQLException {
        oblist.clear();

        String sql = "select * from customer";
        Connection conn = DBConnector.getConnection();


        ResultSet rs = conn.createStatement().executeQuery(sql);

        System.out.println("connected to database");
        try {
        while (rs.next()) {
            System.out.println("trying");
            oblist.add(new ModelTable(
                    rs.getString("cid"),
                    rs.getString("cfname"),
                    rs.getString("clname"),
                    rs.getString("city"),
                    rs.getString("street"),
                    rs.getString("stnumber"),
                    rs.getString("postalcode"),
                    rs.getString("cemail"),
                    rs.getString("cafm")));

        }
        rs.close();
        //stmt.close();
        conn.close();

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }


        col_cid.setCellValueFactory(new PropertyValueFactory<>("cid"));
        col_Fname.setCellValueFactory(new PropertyValueFactory<>("cfname"));
        col_Lname.setCellValueFactory(new PropertyValueFactory<>("clname"));
        col_City.setCellValueFactory(new PropertyValueFactory<>("city"));
        col_Street.setCellValueFactory(new PropertyValueFactory<>("street"));
        col_StNum.setCellValueFactory(new PropertyValueFactory<>("stnumber"));
        col_PostCode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));
        col_Email.setCellValueFactory(new PropertyValueFactory<>("cemail"));
        col_Afm.setCellValueFactory(new PropertyValueFactory<>("cafm"));




            table.setItems(oblist);
    }

    public void Go_back() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage)Go_backBtn.getScene().getWindow();
        window.setScene(new Scene(root,453,500));

    }

    public void add_button() throws SQLException {
        String cidStr = Textcid.getText();
        String fnameStr = Tfname.getText();
        String lnameStr = Tlname.getText();
        String cityStr = Tcity.getText();
        String streetStr = Tstreet.getText();
        String streetnumStr = Tstnum.getText();
        String postalcodeStr = Tps.getText();
        String emailStr = Temail.getText();
        String afmStr = Tafm.getText();

        String add = "insert into customer (cid,cfname,clname,city,street,stnumber,postalcode,cemail,cafm)"+
                "values(?,?,?,?,?,?,?,?,?)";

             String search = "Select * from customer where cid = '" + cidStr + "' ";


            Connection connection = DBConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement(add);

            statement.setString(1, cidStr);
            statement.setString(2, fnameStr);
            statement.setString(3, lnameStr);
            statement.setString(4, cityStr);
            statement.setString(5, streetStr);
            statement.setString(6, streetnumStr);
            statement.setString(7, postalcodeStr);
            statement.setString(8, emailStr);
            statement.setString(9, afmStr);

            int rows = statement.executeUpdate();
            if (rows > 0){
                System.out.println("Succesfully added");
            }

            statement.close();
            connection.close();
            Refresh();


    }

    public void NexScene () throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Farmaka.fxml"));
        Stage window = (Stage)Go_backBtn.getScene().getWindow();
        window.setScene(new Scene(root,1200,800));
    }

    public void Delete(){
        String delete = "delete from customer where cid = ? " ;
        try {

            Connection conn = DBConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(delete);
            statement.setString(1,Selectedcid);
            statement.execute();


            statement.close();
            conn.close();
            Refresh();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }
    int index = -1;
    private String Selectedcid="";
    @FXML

    void getSelected(MouseEvent event){
        index = table.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }

        Selectedcid = col_cid.getCellData(index).toString();

    }
}

