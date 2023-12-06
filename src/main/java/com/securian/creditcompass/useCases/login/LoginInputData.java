package com.securian.creditcompass.useCases.login;

import lombok.Getter;

@Getter
public class LoginInputData{
    private final String username;
    private final String password;

    public LoginInputData(String username, String password) {
        /*
        @param username: the username of the user to log in
        @param password: the password of the user to log in
         */
        this.username = username;
        this.password = password;
    }
}
