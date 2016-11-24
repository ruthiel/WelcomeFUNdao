package org.academiadecodigo.hackaton.welcomefundao;

/**
 * Created by codecadet on 24/11/16.
 */
public class Parser {
    private String methodeName;
    private String username;
    private String password;

    public Parser() {
    }

    public Parser(String methodeName, String username, String password) {
        this.methodeName = methodeName;
        this.username = username;
        this.password = password;
    }

    public String getMethodeName() {
        return methodeName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
