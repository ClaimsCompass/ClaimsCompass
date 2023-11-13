package Login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginAuthService loginAuthService;

    public LoginController(LoginAuthService loginAuthService) {
        this.loginAuthService = loginAuthService;
    }

    @PostMapping ("/login")
    public Boolean Examiner(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return loginAuthService.authenticateExaminer(username, password);
    }

//    @PostMapping("/login")
//    public String loginOutcome(LoginDTO loginOutputData) {
//        if (loginAuthService.authenticateExaminer(loginOutputData.getUsername(), loginOutputData.getPassword())) {
//            return "Login Successful!";
//        } else {
//            return "Invalid input.";
//        }
//
//    }
}
