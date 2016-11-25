package org.academiadecodigo.hackaton.welcomefundao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackaton.welcomefundao.Client;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
import org.academiadecodigo.hackaton.welcomefundao.Parser;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
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
    void hotelsClick(MouseEvent event) {

        /*String[] r = (String[]) o;
        System.out.println(r);

        out.write(om.writeValueAsString(r).getBytes());
        out.write("\n".getBytes());
        out.flush();*/

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


        Navigation.getInstance().loadScreen("hotelContent");
        ((HotelController) Navigation.getInstance().getController("hotelContent")).setClient(client);
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
        Navigation.getInstance().loadScreen("barContent");
        ((BarContentController) Navigation.getInstance().getController("barContent")).setClient(client);
    }

    @FXML
    void rentRoomClick(MouseEvent event) {
        Navigation.getInstance().loadScreen("accommodationMenu");
        ((AccomodationMenuController) Navigation.getInstance().getController("accommodationMenu")).setClient(client);
    }


    @FXML
    void roomsClick(MouseEvent event) {

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
