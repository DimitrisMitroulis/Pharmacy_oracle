package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBConnector {

    //Connection conn = null;

    public static Connection getConnection() throws SQLException {

        String dbURL = "jdbc:oracle:thin:@192.168.1.2:1521:xe";
        String username = "c##pharmacy";
        String password = "tiger";

        Connection conn = DriverManager.getConnection(dbURL, username, password);
        return conn;


    }


}

