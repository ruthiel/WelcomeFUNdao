package org.academiadecodigo.hackaton.welcomefundao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Client.Client;
import org.academiadecodigo.hackaton.welcomefundao.Game.GameMain;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
import org.academiadecodigo.hackaton.welcomefundao.Client.Parser;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 25/11/16.
 */
public class HotelController implements Initializable {
    private UserService userService;
    private Client client;
    private String[] results;
    private int actual;


    public HotelController() {
        System.out.println("reloading");
    }

    public void loadResults(String[] s) {
        System.out.println("Loading");
        System.out.println("my name is:" + Thread.currentThread().getName());
        System.out.println("this.results are:");
        results = s;

        //item_image.setImage(new Image(results[0]));
        item_title.setText(results[1]);
        address.setText(results[2]);
        phone.setText(results[3]);
        avg_price.setText(results[4]);
        actual = 5;


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
        Navigation.getInstance().loadScreen("AcademiaMenu");
        ((AcademiaMenuController) Navigation.getInstance().getController("AcademiaMenu")).setClient(client);
    }

    @FXML
    void cultureClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("culturalContent");
        ((CulturalContentController) Navigation.getInstance().getController("culturalContent")).setClient(client);
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
        String[] s = {"", ""};
        Parser parser = new Parser("foodProperties", s);
        client.sendMessage(parser);


        try {
            String message = client.getIn().readLine();
            ObjectMapper om = new ObjectMapper();

            if (message == null) {
                //
                System.out.println("null");
            } else {
                s = om.readValue(message, String[].class);

                Navigation.getInstance().loadScreen("foodContent");
                ((FoodContentController) Navigation.getInstance().getController("foodContent")).setClient(client);

                ((FoodContentController) Navigation.getInstance().getController("foodContent")).loadResults(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void interestClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("TourismContent");
        ((TourismController) Navigation.getInstance().getController("TourismContent")).setClient(client);
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
    private Button hiddenGame;

    @FXML
    private Button hiddenLadies;

    @FXML
    void hiddenGameClick(ActionEvent event) {
        Navigation.getInstance().loadEasterEgg();

        System.out.println("trying to open the fucking game");
        /*Navigation.getInstance().loadScreen("GameEaster");
        ((GameEasterController) Navigation.getInstance().getController("GameEaster")).setClient(client);
*/
    }

    @FXML
    void ladiesClick(ActionEvent event) {
        Navigation.getInstance().loadScreen("heartEaster");
        ((HeartEasterController) Navigation.getInstance().getController("heartEaster")).setClient(client);
    }

    @FXML
    void mainMenuClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("MainMenu");
        ((MainMenuController) Navigation.getInstance().getController("MainMenu")).setClient(client);
    }

    @FXML
    void previousOnList(MouseEvent event) {
        if (actual - 5 > 0) {
            actual -= 10;
            //item_image.setImage(new Image(results[0]));
            item_title.setText(results[actual + 1]);
            address.setText(results[actual + 2]);
            phone.setText(results[actual + 3]);
            avg_price.setText(results[actual + 4]);
            actual = actual + 5;
        }
    }

    @FXML
    void nextOnList(MouseEvent event) {
        if (actual < results.length) {
            //item_image.setImage(new Image(results[0]));
            item_title.setText(results[actual + 1]);
            address.setText(results[actual + 2]);
            phone.setText(results[actual + 3]);
            avg_price.setText(results[actual + 4]);
            actual = actual + 5;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setClient(Client client) {
        this.client = client;
    }
}
