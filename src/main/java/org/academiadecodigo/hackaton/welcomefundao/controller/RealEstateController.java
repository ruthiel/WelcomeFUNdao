package org.academiadecodigo.hackaton.welcomefundao.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

/**
 * Created by codecadet on 25/11/16.
 */
public class RealEstateController implements Initializable {
    Client client;

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
    private Label address;

    @FXML
    private ImageView item_image;

    @FXML
    private MenuButton query_menu;

    @FXML
    private MenuItem queryNearest;

    @FXML
    private MenuItem queryHigh;

    @FXML
    private MenuItem queryLow;

    @FXML
    private ImageView nextOnList;

    @FXML
    void academiaClick(MouseEvent event) {

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
    void nextOnList(MouseEvent event) {

    }

    @FXML
    void nightLifeClick(MouseEvent event) {

    }

    @FXML
    void queryHighClick(ActionEvent event) {

    }

    @FXML
    void queryLowClick(ActionEvent event) {

    }

    @FXML
    void queryNearestClick(ActionEvent event) {

    }

    @FXML
    void rentRoomClick(MouseEvent event) {

    }

    @FXML
    void settingsClick(MouseEvent event) {

    }


    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}