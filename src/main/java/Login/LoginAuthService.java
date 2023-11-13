package Login;

import entities.ClaimsExaminer;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginAuthService {
    private final LoginRepository loginRepository;
    public LoginAuthService(LoginRepository loginRepository){this.loginRepository = loginRepository;}

    public boolean authenticateExaminer(String username, String password){
        Optional<ClaimsExaminer> examinerOptional= loginRepository.findByUsername(username);
        if (examinerOptional.isPresent()){ // if username input is a valid username in the database, see if password matches.
            ClaimsExaminer examinerAuth = examinerOptional.get();
            String dbPassword = examinerAuth.getPassword();
            return dbPassword.equals(password);}

        return false;
    }

}
