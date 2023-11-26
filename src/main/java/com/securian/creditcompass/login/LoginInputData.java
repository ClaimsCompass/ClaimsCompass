package com.securian.creditcompass.login;

import lombok.Getter;

@Getter
public class LoginInputData{
    private final String username;
    private final String password;

    public LoginInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
