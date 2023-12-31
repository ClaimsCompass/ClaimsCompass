package com.securian.creditcompass.useCases.login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Map;

@RestController
public class LoginController {

    private final LoginInteractor loginService;

    public LoginController(LoginInteractor loginService) {

        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> userInput) {
        /*
        @param userInput: the username and password of the user to log in
        @return: a response indicating whether the login was successful
         */
        String username = userInput.get("username");
        String password = userInput.get("password");
        LoginInputData loginInputData = new LoginInputData(username, password);
        try {
            boolean authenticated = loginService.authenticate(loginInputData);
            if (authenticated) {
                return ResponseEntity.ok("Logging you in...");
            } else {
                return ResponseEntity.status(401).body("Login unsuccessful.");
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

}
