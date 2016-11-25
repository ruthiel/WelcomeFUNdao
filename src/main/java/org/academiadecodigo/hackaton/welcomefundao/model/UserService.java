package org.academiadecodigo.hackaton.welcomefundao.model;

import java.sql.ResultSet;

/**
 * Created by codecadet on 24/11/16.
 */
public interface UserService {

    boolean authenticate(String username, String password);

    boolean changePassword(int id, String newPassword);

    String[] hotelsProperties();

    String[] roomsProperties();

    String[] foodProperties();

    String[] barProperties();

    String[] cultureProperties();

    String[] utilitiesProperties();

    String[] tourismProperties();

    String[] padawansProperties();

}
