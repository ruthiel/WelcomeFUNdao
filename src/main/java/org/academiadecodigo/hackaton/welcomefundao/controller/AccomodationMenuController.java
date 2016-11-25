package org.academiadecodigo.hackaton.welcomefundao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Client;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
import org.academiadecodigo.hackaton.welcomefundao.Parser;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 25/11/16.
 */
public class AccomodationMenuController implements Initializable {
    private Client client;
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

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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
    void hotelsClick(MouseEvent event) {

        String[] s = {"", ""};
        Parser parser = new Parser("hotelsProperties", s);
        client.sendMessage(parser);


        try {
            String message = client.getIn().readLine();
            ObjectMapper om = new ObjectMapper();

            if (message == null) {
                //
                System.out.println("null");
            } else {
                s = om.readValue(message, String[].class);

                Navigation.getInstance().loadScreen("hotelContent");
                ((HotelController) Navigation.getInstance().getController("hotelContent")).setClient(client);

                ((HotelController) Navigation.getInstance().getController("hotelContent")).loadResults(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


       /* Navigation.getInstance().loadScreen("hotelContent");
        ((HotelController) Navigation.getInstance().getController("hotelContent")).setClient(client);*/
    }

    @FXML
    void housesClick(MouseEvent event) {

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
    void roomsClick(MouseEvent event) {
        String[] s = {"", ""};
        Parser parser = new Parser("roomsProperties", s);
        client.sendMessage(parser);


        try {
            String message = client.getIn().readLine();
            ObjectMapper om = new ObjectMapper();

            if (message == null) {
                //
                System.out.println("null");
            } else {
                s = om.readValue(message, String[].class);

                Navigation.getInstance().loadScreen("roomContent");
                ((RoomContentController) Navigation.getInstance().getController("roomContent")).setClient(client);

                ((RoomContentController) Navigation.getInstance().getController("roomContent")).loadResults(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void settingsClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("userContent");
        ((UserContentController) Navigation.getInstance().getController("userContent")).setClient(client);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setClient(Client client) {
        this.client = client;
    }
}
