package org.academiadecodigo.hackaton.welcomefundao.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by codecadet on 24/11/16.
 */
public class ClientHandler implements Runnable, Serializable{
    private ObjectOutputStream out;
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {

            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());

            //UserService userService = new MockUserService();


            Object readingObj;

            while (true) {
                //wait for Client request
                readingObj = in.readObject();

                if (readingObj == null) {
                    System.out.println("closing connection");
                    return;
                }

                if (readingObj instanceof String) {

                    String[] userLogin = ((String) readingObj).split("[.]");
                    System.out.println("\n --Auth attempt-- ");
                    System.out.println("username: " + userLogin[0] + "\npassword: " + userLogin[1]+"\n");

                }
            }


        } catch (EOFException e) {
            System.out.println("Server closed the connection");
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.out.println("Unknown object");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void send(Object obj){
        try {
            out.reset(); //To avoid accumulating the buffer, the buffer shall be reset before writing in it.
            out.writeObject(obj);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
