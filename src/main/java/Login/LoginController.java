package Login;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
}
