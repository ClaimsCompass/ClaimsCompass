package com.securian.creditcompass.login;

import org.springframework.http.ResponseEntity;

public interface LoginInputBoundary {
    ResponseEntity<Object> authenticate(LoginInputData loginInputData);
}
