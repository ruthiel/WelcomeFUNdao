package org.academiadecodigo.hackaton.welcomefundao.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Client;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
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
    private Client client;
    private String[] results;

    public HotelController() {
        System.out.println("i am being constructed");
    }

    public void loadResults(String[] results) {
        System.out.println("Loading");
        System.out.println("my name is:" + Thread.currentThread().getName());
        System.out.println("this.results are:" + this.results);
        this.results = results;

        for (String r:results) {
            System.out.println(r);
        }

        //item_image.setImage(new Image(results[5]));
        item_title.setText(results[1]);
        address.setText(results[2]);
        phone.setText(results[3]);
        avg_price.setText(results[4]);

        System.out.println(this.results);

    }

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
        System.out.println("my name is (inside academiaClick):" + Thread.currentThread().getName());

        System.out.println("clicked");
        System.out.println(results.length);
        System.out.println("again");
        item_title.setText(results[1]);
        address.setText(results[2]);
        phone.setText(results[3]);
        avg_price.setText(results[4]);

        /*Navigation.getInstance().loadScreen("AcademiaMenu");
        ((AcademiaMenuController) Navigation.getInstance().getController("AcademiaMenu")).setClient(client);*/
    }

    @FXML
    void cultureClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("culturalContent");
        ((CulturalContentController) Navigation.getInstance().getController("culturalContent")).setClient(client);
    }

    @FXML
    void emergencyClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("EmergencyContent");
        ((EmergencyContentController) Navigation.getInstance().getController("EmergencyContent")).setClient(client);
    }

    @FXML
    void foodClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("foodContent");
        ((FoodContentController) Navigation.getInstance().getController("foodContent")).setClient(client);
    }

    @FXML
    void interestClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("TourismContent");
        ((TourismController) Navigation.getInstance().getController("TourismContent")).setClient(client);
    }

    @FXML
    void nightLifeClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("barContent");
        ((BarContentController) Navigation.getInstance().getController("barContent")).setClient(client);
    }

    @FXML
    void rentRoomClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("accommodationMenu");
        ((AccomodationMenuController) Navigation.getInstance().getController("accommodationMenu")).setClient(client);
    }

    @FXML
    void settingsClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("userContent");
        ((UserContentController) Navigation.getInstance().getController("userContent")).setClient(client);
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
    void nextOnList(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setClient(Client client) {
        this.client = client;
    }
}
