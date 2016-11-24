package org.academiadecodigo.hackaton.welcomefundao.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.hackaton.welcomefundao.Parser;
import org.academiadecodigo.hackaton.welcomefundao.model.JdbcUserService;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;
import org.academiadecodigo.hackaton.welcomefundao.persitence.ConnectionManager;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by codecadet on 24/11/16.
 */
public class ClientHandler implements Runnable, Serializable {
    private DataOutputStream out;
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());

            String reader;

            while (true) {
                //wait for Client request
                reader = in.readLine();
                System.out.println(reader);
                //reader = reader.substring(0, reader.length());
                System.out.println(reader);

                if (reader == null) {
                    System.out.println("closing connection");
                    return;
                }

                ObjectMapper om = new ObjectMapper();
                ConnectionManager connectionManager = new ConnectionManager();
                UserService userService = new JdbcUserService(connectionManager);

                Parser parser = om.readValue(reader, Parser.class);
                System.out.println("here");
                System.out.println(parser.getMethodeName());

                Method method = userService.getClass().getMethod(parser.getMethodeName(), parser.getUsername().getClass(), parser.getPassword().getClass());
                method.invoke(userService,parser.getUsername(),parser.getPassword());
            }


        } catch (EOFException e) {
            System.out.println("Server closed the connection");
            System.exit(1);
        }  catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    private void send(String s) {
        try {
            out.write(s.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
