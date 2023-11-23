package com.securian.creditcompass.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {
    private final LoginInteractor loginService;

    public LoginController(LoginInteractor loginService) {

        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> userInput) {
        String username = userInput.get("username");
        String password = userInput.get("password");
        LoginInputData loginInputData = new LoginInputData(username, password);
        return loginService.authenticate(loginInputData);
    }

}
