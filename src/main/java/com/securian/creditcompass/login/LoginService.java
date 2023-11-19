package com.securian.creditcompass.login;

import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public String authenticate(String username, String password){
        Optional<ClaimsExaminer> optionalExaminer = loginRepository.findByUsername(username);
        if (optionalExaminer.isPresent()){
            ClaimsExaminer examiner = optionalExaminer.get();

            String dbPassword = examiner.getPassword();

            if( dbPassword.equals(password)){
                return "Logging you in....";
            } else {
                return "Incorrect credentials.";
            }
        }
        return "Incorrect credentials.";
    }

}
