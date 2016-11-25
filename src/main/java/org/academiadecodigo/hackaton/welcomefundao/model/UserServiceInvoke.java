package org.academiadecodigo.hackaton.welcomefundao.model;

/**
 * Created by codecadet on 25/11/16.
 */
public class UserServiceInvoke {
    private JdbcUserService jdbcUserService;

    public UserServiceInvoke(){
        System.out.println("here");
    }

    public void invoke(String[] args){
        switch (args[0]){
            case "authenticate":{
                jdbcUserService.authenticate(args[1], args[2]);
                break;
            }
        }
    }

    public void setJdbcUserService(JdbcUserService jdbcUserService) {
        this.jdbcUserService = jdbcUserService;
    }
}
