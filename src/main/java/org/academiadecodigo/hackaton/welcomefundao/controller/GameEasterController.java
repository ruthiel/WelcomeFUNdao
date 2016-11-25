package org.academiadecodigo.hackaton.welcomefundao.controller;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;

/**
 * Created by codecadet on 25/11/16.
 */
public class GameEasterController implements Initializable {
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
    private ImageView game;

    @FXML
    void academiaClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("AcademiaMenu");
        ((AcademiaMenuController)Navigation.getInstance().getController("AcademiaMenu")).setClient(client);
    }

    @FXML
    void cultureClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("culturalContent");
        ((AcademiaMenuController)Navigation.getInstance().getController("culturalContent")).setClient(client);
    }

    @FXML
    void emergencyClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("EmergencyContent");
        ((EmergencyContentController)Navigation.getInstance().getController("EmergencyContent")).setClient(client);
    }

    @FXML
    void foodClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("foodContent");
        ((FoodContentController)Navigation.getInstance().getController("foodContent")).setClient(client);
    }

    @FXML
    void gameClick(MouseEvent event) {

    }

    @FXML
    void interestClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("TourismContent");
        ((TourismController)Navigation.getInstance().getController("TourismContent")).setClient(client);
    }

    @FXML
    void nightLifeClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("barContent");
        ((BarContentController)Navigation.getInstance().getController("barContent")).setClient(client);
    }

    @FXML
    void rentRoomClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("accommodationMenu");
        ((AccomodationMenuController)Navigation.getInstance().getController("accommodationMenu")).setClient(client);
    }

    @FXML
    void settingsClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("userContent");
        ((UserContentController)Navigation.getInstance().getController("userContent")).setClient(client);
    }


    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
