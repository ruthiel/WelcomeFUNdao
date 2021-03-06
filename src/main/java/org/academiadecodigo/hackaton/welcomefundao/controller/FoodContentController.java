package org.academiadecodigo.hackaton.welcomefundao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Client.Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
import org.academiadecodigo.hackaton.welcomefundao.Client.Parser;

/**
 * Created by codecadet on 25/11/16.
 */
public class FoodContentController implements Initializable {
    Client client;
    private String[] results;
    private int actual;

    public void loadResults(String[] s) {

        results = s;

        //item_image.setImage(new Image(results[0]));
        item_title.setText(results[0]);
        phone.setText(results[1]);
        address.setText(results[2]);
        type_food.setText(results[3]);
        distance_AC.setText(results[4]);
        website.setText(results[5]);
        stars.setText(results[6]);

        actual = 6;


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
    private Label address;

    @FXML
    private Label avg_price;

    @FXML
    private Label price_title;

    @FXML
    private Label type_food;

    @FXML
    private Label food_title;

    @FXML
    private Label distance;

    @FXML
    private Label distance_AC;

    @FXML
    private Label website;

    @FXML
    private Label stars;

    @FXML
    private Label stars_title;

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
        Navigation.getInstance().loadScreen("AcademiaMenu");
        ((AcademiaMenuController)Navigation.getInstance().getController("AcademiaMenu")).setClient(client);
    }

    @FXML
    void cultureClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("culturalContent");
        ((CulturalContentController)Navigation.getInstance().getController("culturalContent")).setClient(client);
    }

    @FXML
    void emergencyClick(MouseEvent event) {
        String[] s = {"", ""};
        Parser parser = new Parser("utilitiesProperties", s);
        client.sendMessage(parser);


        try {
            String message = client.getIn().readLine();
            ObjectMapper om = new ObjectMapper();

            if (message == null) {
                //
                System.out.println("null");
            } else {
                s = om.readValue(message, String[].class);

                Navigation.getInstance().loadScreen("EmergencyContent");
                ((EmergencyContentController) Navigation.getInstance().getController("EmergencyContent")).setClient(client);

                ((EmergencyContentController) Navigation.getInstance().getController("EmergencyContent")).loadResults(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void foodClick(MouseEvent event) {

    }

    @FXML
    void interestClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("TourismContent");
        ((TourismController)Navigation.getInstance().getController("TourismContent")).setClient(client);
    }

    @FXML
    void nextOnList(MouseEvent event) {

    }

    @FXML
    void mainMenuClick(MouseEvent event){
        Navigation.getInstance().loadScreen("MainMenu");
        ((MainMenuController) Navigation.getInstance().getController("MainMenu")).setClient(client);
    }

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
    void nightLifeClick(MouseEvent event) {
        String[] s = {"", ""};
        Parser parser = new Parser("barProperties", s);
        client.sendMessage(parser);


        try {
            String message = client.getIn().readLine();
            ObjectMapper om = new ObjectMapper();

            if (message == null) {
                //
                System.out.println("null");
            } else {
                s = om.readValue(message, String[].class);

                Navigation.getInstance().loadScreen("barContent");
                ((BarContentController) Navigation.getInstance().getController("barContent")).setClient(client);

                ((BarContentController) Navigation.getInstance().getController("barContent")).loadResults(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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