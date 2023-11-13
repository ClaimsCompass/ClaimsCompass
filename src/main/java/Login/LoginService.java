package Login;

import entities.ClaimsExaminer;
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
        if (examiner.isPresent()){ // if username input is a valid username in the database, see if password matches.
            ClaimsExaminer examiner = optionalExaminer.get();
            String dbPassword = examinerAuth.getPassword();
            if( dbPassword.equals(password)){
                return "Success.";
            }
            }
        return "Failure";
        // Find the if there exists a claims examiner with the inputted username in the database
        // If a claim examiner exists in the database
        //
    }

}
