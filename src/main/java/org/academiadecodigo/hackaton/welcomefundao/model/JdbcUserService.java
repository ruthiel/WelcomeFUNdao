package org.academiadecodigo.hackaton.welcomefundao.model;

import org.academiadecodigo.hackaton.welcomefundao.persitence.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

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

           if (resultSet == 1) {
                System.out.println("Password changed with success");
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
    public String[] hotelsProperties() {
        try {
            checkConnection();

            Statement statement = dbConnection.createStatement();
            /*String queryPhoto = "SELECT photo FROM accomodation AS a WHERE a.accomodation_id = 1;";
            String queryName = "SELECT accomodation_name FROM accomodation AS a WHERE a.accomodation_id = 1;";
            String queryAddress = "SELECT address FROM accomodation AS a JOIN location AS  l USING (location_id) WHERE l.location_id = 50;";
            String queryContact = "SELECT contact FROM accomodation AS a WHERE a.accomodation_id = 1;";
            String queryAvgPrice = "SELECT average_price FROM accomodation AS a WHERE a.accomodation_id = 1;";*/

            String query = "SELECT photo, accomodation_name, address, contact, average_price FROM accomodation, location WHERE (accomodation.location_id = location.location_id);";
            ResultSet resultSet = statement.executeQuery(query);

            LinkedList<String > list = new LinkedList();
            while (resultSet.next()){
                for (int i = 1; i <6 ; i++) {
                    list.add(resultSet.getString(i));
                }
            }

            String[] toReturn = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                toReturn[i] = list.get(i);
            }

            return toReturn;


            //return resultSet;


        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return null;
    }
}
