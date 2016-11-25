package org.academiadecodigo.hackaton.welcomefundao.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 25/11/16.
 */
public class AccomodationMenuController implements Initializable {
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
    private ImageView hotels;

    @FXML
    private ImageView houses;

    @FXML
    private ImageView rooms;

    @FXML
    void academiaClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("AcademiaMenu");
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
    void hotelsClick(MouseEvent event) {

    }

    @FXML
    void housesClick(MouseEvent event) {

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
    void roomsClick(MouseEvent event) {

    }

    @FXML
    void settingsClick(MouseEvent event) {

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
