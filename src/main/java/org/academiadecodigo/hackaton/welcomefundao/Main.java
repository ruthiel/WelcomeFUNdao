package org.academiadecodigo.hackaton.welcomefundao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.hackaton.welcomefundao.model.JdbcUserService;
import org.academiadecodigo.hackaton.welcomefundao.persitence.ConnectionManager;

import java.sql.Connection;
import java.util.Collection;

/**
 * Created by codecadet on 24/11/16.
 */
public class Main {
    public static void main(String[] args) {

        ConnectionManager manager = new ConnectionManager();
        JdbcUserService jdbcUserService = new JdbcUserService(manager);

  /*      ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString();
        Client c = om.readValue(s, Client.class);*/


        /*jdbcUserService.changePassword(1, "teste");

        jdbcUserService.authenticate("Eurico Fonseca", "123456");*/


    }
}
