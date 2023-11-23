package com.securian.creditcompass.login;

import com.securian.creditcompass.entities.ClaimsExaminer;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public ResponseEntity<Object> authenticate(String username, String password){
        Optional<ClaimsExaminer<T>> optionalExaminer = loginRepository.findByUsername(username);
        if (optionalExaminer.isPresent()){
            ClaimsExaminer<T> examiner = optionalExaminer.get();

            String dbPassword = examiner.getPassword();

            if( dbPassword.equals(password)){
                return ResponseEntity.ok("Logging you in...");
            } else {
                ErrorObject errorObject = new ErrorObject("invalid Input.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);
            }
        }
        ErrorObject errorObject = new ErrorObject("invalid Input.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);
    }

//    @PostMapping("/login")
//    public ResponseEntity<Object> loginOutcome(@RequestBody LoginDTO loginTransferData){
//        if (loginAuthService.authenticateExaminer(loginTransferData.getUsername(), loginTransferData.getPassword())){
//            // Successful Login
//            return ResponseEntity.ok("Login Successful");
//        } else {
//            // Unsuccessful login - returns JSON obj with error information.
//            ErrorObject errorObject = new ErrorObject("invalid Input.");
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);
//        }
//    }
    @Getter
    private static class ErrorObject {
        private final String error;
        public ErrorObject(String error) {
            this.error = error;
        }
    }
}

