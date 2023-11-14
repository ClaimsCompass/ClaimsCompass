package com.securian.creditcompass.login;

import com.securian.creditcompass.login.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {

        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDataTransferObject loginDataTransferObject) {
        return loginService.authenticate(loginDataTransferObject.getUsername(), loginDataTransferObject.getPassword());
    }

}
