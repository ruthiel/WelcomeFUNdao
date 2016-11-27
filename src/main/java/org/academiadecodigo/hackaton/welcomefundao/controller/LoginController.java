package org.academiadecodigo.hackaton.welcomefundao.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import org.academiadecodigo.hackaton.welcomefundao.Client.Client;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
import org.academiadecodigo.hackaton.welcomefundao.Client.Parser;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 24/11/16.
 */
public class LoginController implements Initializable {
    private UserService userService;
    private Client client;



    @FXML
    private Pane backgroundPane;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Rectangle rectangleLogin;

    @FXML
    private VBox windowLogin;

    @FXML
    private ImageView checkUncheckImage;

    @FXML
    private ImageView userImage;

    @FXML
    private TextField userTextField;

    @FXML
    private ImageView passwordImage;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signIn;

    @FXML
    private Label messageNotCadet;

    @FXML
    void informationNotCadet(MouseEvent event) {

    }

    @FXML
    void signInClick(MouseEvent event) {
        String[] s = {userTextField.getText(),passwordField.getText()};
        Parser parser = new Parser("authenticate", s);
        client.sendMessage(parser);
        try {
            if(client.getIn().readLine().equals("true")){
                Navigation.getInstance().loadScreen("MainMenu");
                ((MainMenuController)Navigation.getInstance().getController("MainMenu")).setClient(client);
            }else {
                Navigation.getInstance().loadScreen("FailedLogin_FUNdao");
                ((LoginController)Navigation.getInstance().getController("FailedLogin_FUNdao")).setClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
