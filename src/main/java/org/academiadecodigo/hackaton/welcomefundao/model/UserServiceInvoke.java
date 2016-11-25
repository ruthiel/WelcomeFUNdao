package org.academiadecodigo.hackaton.welcomefundao.model;

import java.sql.ResultSet;

/**
 * Created by codecadet on 25/11/16.
 */
public class UserServiceInvoke {
    private JdbcUserService jdbcUserService;

    public UserServiceInvoke(){
        System.out.println("here");
    }

   /* public void invoke(String[] args){
        switch (args[0]){
            case "authenticate":{
                jdbcUserService.authenticate(args[1], args[2]);
                break;
            }
            case "hotelsProperties":

        }
    }*/

    public boolean authenticate(String[] args){
        return  jdbcUserService.authenticate(args[0], args[1]);
    }

    public String[] hotelsProperties(String[] args){
        System.out.println("hotels");
        return jdbcUserService.hotelsProperties();
    }

    public void setJdbcUserService(JdbcUserService jdbcUserService) {
        this.jdbcUserService = jdbcUserService;
    }
}
