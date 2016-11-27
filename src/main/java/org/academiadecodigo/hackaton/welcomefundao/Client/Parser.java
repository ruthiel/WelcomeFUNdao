package org.academiadecodigo.hackaton.welcomefundao.Client;

/**
 * Created by codecadet on 24/11/16.
 */
public class Parser {
    private String methodName;
    private String[] args;

    public Parser() {
    }

    public Parser(String methodName, String[] args) {
        this.methodName = methodName;
        this.args = args;
    }

    public String getMethodName() {
        return methodName;
    }

    public String[] getArgs() {
        return args;
    }
}
