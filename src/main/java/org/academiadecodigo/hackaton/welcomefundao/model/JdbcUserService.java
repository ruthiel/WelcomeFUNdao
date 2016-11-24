package org.academiadecodigo.hackaton.welcomefundao.model;

import org.academiadecodigo.hackaton.welcomefundao.persitence.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by codecadet on 24/11/16.
 */
public class JdbcUserService implements UserService {

    private Connection dbConnection;
    private ConnectionManager manager;

    public JdbcUserService(ConnectionManager manager) {
        this.manager = manager;
        dbConnection = manager.getConnection();
    }

    private void checkConnection() {
        try {
            if (dbConnection == null || dbConnection.isClosed()) {
                dbConnection = manager.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (dbConnection == null) {
            throw new IllegalStateException("Error connection to database!");
        }
    }

    public boolean authenticate(String username, String password) {

        boolean result = false;

        try {
            checkConnection();

            Statement statement = dbConnection.createStatement();
            String query = "SELECT name, password FROM users WHERE name = \"" + username + "\" AND password = \"" + password + "\"";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("Bem vindo(a) " + username);
                return true;
            }

            if (statement != null) {
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean changePassword(int id, String newPassword) {
        boolean result = false;

        try {
            checkConnection();

            Statement statement = dbConnection.createStatement();
            String query = "UPDATE users SET password = \"" + newPassword + "\" WHERE user_id = " + id;
            int resultSet = statement.executeUpdate(query);

            /*f (resultSet.next()) {
                System.out.println("Password changed with success");
                return true;
            }*/

            if (statement != null) {
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
