package com.securian.creditcompass.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private final LoginInteractor loginService;

    public LoginController(LoginInteractor loginService) {

        this.loginService = loginService;
    }

    @PostMapping("/login")
//    public ResponseEntity<Object> login(@RequestParam ("username") String username,
//                                        @RequestParam ("password")String password) {
    public ResponseEntity<Object> login(@RequestParam ("username") String username, @RequestParam ("password") String password) {
       LoginInputData loginInputData = new LoginInputData(username, password);
        return loginService.authenticate(loginInputData);
    }

}
