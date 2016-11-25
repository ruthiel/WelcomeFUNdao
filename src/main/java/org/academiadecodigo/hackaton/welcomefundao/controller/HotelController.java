package org.academiadecodigo.hackaton.welcomefundao.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 25/11/16.
 */
public class HotelController implements Initializable {
    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private ImageView rentRoom;

    @FXML
    private ImageView food;

    @FXML
    private ImageView interest;

    @FXML
    private ImageView academia;

    @FXML
    private ImageView nightLife;

    @FXML
    private ImageView culture;

    @FXML
    private ImageView emergency;

    @FXML
    private ImageView settings;

    @FXML
    private Label item_title;

    @FXML
    private Label item_description;

    @FXML
    private Label phone;

    @FXML
    private Label email;

    @FXML
    private Label address;

    @FXML
    private Label avg_price;

    @FXML
    private Label price_title;

    @FXML
    private ImageView item_image;

    @FXML
    void academiaClick(MouseEvent event) {
     /*   ResultSet resultSet = userService.hotelsProperties();
        System.out.println("here");

        try {
            if (resultSet.next()) {
                System.out.println(resultSet.getString(2));
                item_image.setImage(new Image("https://pbs.twimg.com/profile_images/594944901424488448/51V9SvIo.jpg"));
                item_title.setText(resultSet.getString(2));
                address.setText(resultSet.getString(3));
                phone.setText(resultSet.getString(4));
                avg_price.setText(resultSet.getString(5) + "€");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    void cultureClick(MouseEvent event) {

    }

    @FXML
    void emergencyClick(MouseEvent event) {

    }

    @FXML
    void foodClick(MouseEvent event) {

    }

    @FXML
    void interestClick(MouseEvent event) {

    }

    @FXML
    void nightLifeClick(MouseEvent event) {

    }

    @FXML
    void rentRoomClick(MouseEvent event) {

    }

    @FXML
    void settingsClick(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
