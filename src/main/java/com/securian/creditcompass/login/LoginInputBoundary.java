package com.securian.creditcompass.login;

import org.springframework.http.ResponseEntity;

import javax.naming.AuthenticationException;

public interface LoginInputBoundary {
    boolean authenticate(LoginInputData loginInputData) throws AuthenticationException;
}
