package com.securian.creditcompass.login;

import com.securian.creditcompass.entities.ClaimsExaminer;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Service
public class LoginInteractor implements LoginInputBoundary{
    private final LoginDataAccessInterface loginDataAccessInterface;
    public LoginInteractor(LoginDataAccessInterface loginDataAccessInterface){
        this.loginDataAccessInterface = loginDataAccessInterface;
    }

    @Override
    public boolean authenticate(LoginInputData loginInputData) throws AuthenticationException{
        Optional<ClaimsExaminer> optionalExaminer = loginDataAccessInterface.findByUsername(loginInputData.getUsername());
        if (optionalExaminer.isPresent()){
            ClaimsExaminer examiner = optionalExaminer.get();

            String dbPassword = examiner.getPassword();

            if( dbPassword.equals(loginInputData.getPassword())){
                System.out.println("It enters the branch");
                return true;//ResponseEntity.ok("Logging you in...");
            } else {
                throw new AuthenticationException("Invalid credentials.");


            }
        }
        throw new AuthenticationException("Incorrect credentials.");

    }
}

