package org.academiadecodigo.hackaton.welcomefundao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Client.Client;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
import org.academiadecodigo.hackaton.welcomefundao.Client.Parser;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 24/11/16.
 */
public class MainMenuController implements Initializable {
    private UserService userService;
    private Client client;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}

