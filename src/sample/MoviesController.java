package sample;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MoviesController {
@FXML
private ImageView pic;
@FXML
public Button backButton;
@FXML
private GridPane grid;
@FXML
private Image image;
int counter = 0;

ArrayList<File> fileList = new ArrayList<File>();
HBox hb = new HBox();


    public void loadElements() throws UnsupportedEncodingException {
        String path = URLDecoder.decode("scr/Icons/img2.png","UTF-8");



        grid.setPadding(new Insets(7,7,7,7));
        grid.setHgap(10);
        grid.setVgap(10);


        try {
            String sql = "select * from games";
            Connection conn = DBConnector.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("connected to database");
            while (rs.next()) {
                counter=+1;
                System.out.println("trying"+counter);


            }
            rs.close();
            stmt.close();

            conn.close();
            System.out.println("connection closed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        int rows = (counter / 4) + 1;
        int columns = 4;
        int index = 1;
        pic = new ImageView();
        pic.setFitWidth(160);
        pic.setFitHeight(220);
        //image = new Image(String.valueOf(folder));
        pic.setImage(image);
        pic.setId("4");
        hb.getChildren().add(pic);
        GridPane.setConstraints(pic, 1, 1, 1, 1, HPos.CENTER, VPos.CENTER);

        grid.getChildren().addAll(pic);

        pic.setOnMouseClicked(e -> {
            System.out.println("it worked");
        });


    }
}
