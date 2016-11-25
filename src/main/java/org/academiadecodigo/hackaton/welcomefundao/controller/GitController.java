package org.academiadecodigo.hackaton.welcomefundao.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Client;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;

/**
 * Created by codecadet on 25/11/16.
 */
public class GitController implements Initializable {
    Client client;

    public void setClient(Client client) {
        this.client = client;
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
    private ImageView arrowMainMenu;

    @FXML
    private Label item_title;

    @FXML
    private Label item_description;

    @FXML
    private Button user_button;

    @FXML
    private Button hiddenGame;

    @FXML
    private Button hiddenLadies;

    @FXML
    void hiddenGameClick(ActionEvent event) {
        Navigation.getInstance().loadScreen("GameEaster");
        ((GameEasterController) Navigation.getInstance().getController("GameEaster")).setClient(client);

    }

    @FXML
    void ladiesClick(ActionEvent event) {
        Navigation.getInstance().loadScreen("heartEaster");
        ((HeartEasterController) Navigation.getInstance().getController("heartEaster")).setClient(client);
    }



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
    void linkToGitHub(ActionEvent event) {
        
    }

    @FXML
    void mainMenuClick(MouseEvent event){
        Navigation.getInstance().loadScreen("MainMenu");
        ((MainMenuController) Navigation.getInstance().getController("MainMenu")).setClient(client);
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
