package org.academiadecodigo.hackaton.welcomefundao;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.hackaton.welcomefundao.controller.LoginController;
import org.academiadecodigo.hackaton.welcomefundao.model.JdbcUserService;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;
import org.academiadecodigo.hackaton.welcomefundao.persitence.ConnectionManager;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by codecadet on 24/11/16.
 */
public class Client {
    DataOutputStream out;
    BufferedReader in;
    /**
     * Contains the logic of the player
     */
    public void start() {
        try {
            System.out.println("staring player");
            Socket socket = new Socket(InetAddress.getByName("localhost"), 2000);
            out = new DataOutputStream(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Cursor's initial position
            ObjectMapper om = new ObjectMapper();
            String[] args = {"Eurico Fonseca", "teste"};

            Parser parser = new Parser("hotelsProperties", args);

            String s = om.writeValueAsString(parser);


           /*out.write(s.getBytes());
            out.write("\n".getBytes());
            out.flush();

            System.out.println(in.readLine());*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Parser parser){
        try {
            ObjectMapper om = new ObjectMapper();
            String message = om.writeValueAsString(parser);
            out.write(message.getBytes());
            out.write("\n".getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BufferedReader getIn() {
        return in;
    }
}

