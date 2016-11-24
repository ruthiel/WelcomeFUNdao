package org.academiadecodigo.hackaton.welcomefundao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.academiadecodigo.hackaton.welcomefundao.controller.LoginController;
import org.academiadecodigo.hackaton.welcomefundao.model.JdbcUserService;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;
import org.academiadecodigo.hackaton.welcomefundao.persitence.ConnectionManager;

/**
 * Created by codecadet on 24/11/16.
 */
public class screen extends Application{
    private FXMLLoader fxmlLoader;
    private Parent root;

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Navigation.getInstance().setStage(primaryStage);

        Navigation.getInstance().loadScreen("Login_FUNdao");
        ConnectionManager connectionManager = new ConnectionManager();
        UserService userService = new JdbcUserService(connectionManager);

        ((LoginController)Navigation.getInstance().getController("Login_FUNdao")).setUserService(userService);

    }
}
