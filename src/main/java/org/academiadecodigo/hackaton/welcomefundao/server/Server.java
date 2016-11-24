package org.academiadecodigo.hackaton.welcomefundao.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codecadet on 24/11/16.
 */
public class Server {
    private int portNumber;

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public static void main(String[] args) {
        Server server = new Server(2000);

        server.start();

    }

    private void start() {


        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                //wait for new client connection
                System.out.println("Waiting for connection");
                Socket clientSocket = serverSocket.accept();


                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
