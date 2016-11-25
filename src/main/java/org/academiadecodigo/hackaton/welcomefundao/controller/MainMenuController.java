package org.academiadecodigo.hackaton.welcomefundao.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 24/11/16.
 */
public class MainMenuController implements Initializable {
    private UserService userService;

    @FXML
    private Label textMenu;

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
    void academiaClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("AcademiaMenu");
        //((MainMenuController)Navigation.getInstance().getController("MainMenu")).setUserService(userService);
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
        Navigation.getInstance().loadScreen("accommodationMenu");
        ((AccomodationMenuController)Navigation.getInstance().getController("accommodationMenu")).setUserService(userService);
    }

    @FXML
    void settingsClick(MouseEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
