package org.academiadecodigo.hackaton.welcomefundao.Client;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;
import org.academiadecodigo.hackaton.welcomefundao.controller.LoginController;
import org.academiadecodigo.hackaton.welcomefundao.model.JdbcUserService;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;
import org.academiadecodigo.hackaton.welcomefundao.persitence.ConnectionManager;

/**
 * Created by codecadet on 25/11/16.
 */
public class ClientScreen extends Application {
    private Client client;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        client = new Client();
        client.start();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Navigation.getInstance().setStage(primaryStage);


        Navigation.getInstance().loadScreen("Login_FUNdao");
        ConnectionManager connectionManager = new ConnectionManager();
        UserService userService = new JdbcUserService(connectionManager);

        //((LoginController)Navigation.getInstance().getController("Login_FUNdao")).setUserService(userService);
        ((LoginController)Navigation.getInstance().getController("Login_FUNdao")).setClient(client);
    }
}
