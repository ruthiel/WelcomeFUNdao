package org.academiadecodigo.hackaton.welcomefundao.model;

import java.sql.ResultSet;

/**
 * Created by codecadet on 24/11/16.
 */
public interface UserService {

    boolean authenticate(String username, String password);

    boolean changePassword(int id, String newPassword);

    String[] hotelsProperties();


}
