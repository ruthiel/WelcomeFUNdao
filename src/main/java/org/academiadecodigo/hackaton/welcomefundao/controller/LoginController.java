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
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 24/11/16.
 */
public class LoginController implements Initializable {
    private UserService userService;


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
        if(!userService.authenticate(userTextField.getText(), passwordField.getText())){

            Navigation.getInstance().loadScreen("FailedLogin_FUNdao");
        }else {
            System.out.println("login");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
