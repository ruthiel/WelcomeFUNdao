package org.academiadecodigo.hackaton.welcomefundao.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.hackaton.welcomefundao.Parser;
import org.academiadecodigo.hackaton.welcomefundao.model.JdbcUserService;
import org.academiadecodigo.hackaton.welcomefundao.model.UserService;
import org.academiadecodigo.hackaton.welcomefundao.model.UserServiceInvoke;
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

                if (reader == null) {
                    System.out.println("closing connection");
                    return;
                }

                ObjectMapper om = new ObjectMapper();
                ConnectionManager connectionManager = new ConnectionManager();
                UserService userService = new JdbcUserService(connectionManager);

                UserServiceInvoke userServiceInvoke = new UserServiceInvoke();
                Parser parser = om.readValue(reader, Parser.class);


                userServiceInvoke.setJdbcUserService((JdbcUserService) userService);


                Method method = userServiceInvoke.getClass().getMethod(parser.getMethodName(), parser.getArgs().getClass());
                method.invoke(userServiceInvoke, new Object[]{parser.getArgs()});
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
