package org.academiadecodigo.hackaton.welcomefundao;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by codecadet on 24/11/16.
 */
public class Player {

    public static void main(String[] args) {
        Player player = new Player();
        player.start();
    }

    /**
     * Contains the logic of the player
     */
    private void start() {
        try {
            System.out.println("staring player");
            Socket socket = new Socket(InetAddress.getByName("localhost"), 2000);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Cursor's initial position
            ObjectMapper om = new ObjectMapper();

            Parser parser = new Parser("authenticate", "Eurico Fonseca", "teste");

            String s = om.writeValueAsString(parser);


           out.write(s.getBytes());
            out.write("\n".getBytes());
            out.flush();

            in.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

