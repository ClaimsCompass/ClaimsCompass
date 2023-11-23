package com.securian.creditcompass.login;

import com.securian.creditcompass.entities.ClaimsExaminer;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginInteractor implements LoginInputBoundary{
    private final LoginDataAccessInterface loginDataAccessInterface;
    public LoginInteractor(LoginDataAccessInterface loginDataAccessInterface){
        this.loginDataAccessInterface = loginDataAccessInterface;
    }

    @Override
    public ResponseEntity<Object> authenticate(LoginInputData loginInputData){
        Optional<ClaimsExaminer> optionalExaminer = loginDataAccessInterface.findByUsername(loginInputData.getUsername());
        if (optionalExaminer.isPresent()){
            ClaimsExaminer examiner = optionalExaminer.get();

            String dbPassword = examiner.getPassword();

            if( dbPassword.equals(loginInputData.getPassword())){
                System.out.println("It enters the branch");
                return ResponseEntity.ok("Logging you in...");
            } else {
                ErrorObject errorObject = new ErrorObject("Invalid credentials.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);
            }
        }
        ErrorObject errorObject = new ErrorObject("Incorrect credentials.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);
    }
    
    @Getter
    private static class ErrorObject {
        private final String error;
        public ErrorObject(String error) {
            this.error = error;
        }
    }
}

