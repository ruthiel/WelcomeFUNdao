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
public class AcademiaMenuController implements Initializable{
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
    private ImageView padawans;

    @FXML
    private ImageView books;

    @FXML
    private ImageView code;

    @FXML
    void academiaClick(MouseEvent event) {

    }

    @FXML
    void booksClick(MouseEvent event) {

    }

    @FXML
    void codeClick(MouseEvent event) {

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
    void padawansClick(MouseEvent event) {

    }

    @FXML
    void rentRoomClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("accommodationMenu");
    }

    @FXML
    void settingsClick(MouseEvent event) {

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
