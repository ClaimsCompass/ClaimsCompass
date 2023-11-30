package com.securian.creditcompass.login;

import com.securian.creditcompass.dataAccess.ExaminerRepository;
import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Service
public class LoginInteractor implements LoginInputBoundary{
    private final ExaminerRepository examinerRepository;
    public LoginInteractor(ExaminerRepository examinerRepository){
        this.examinerRepository = examinerRepository;
    @Override
    public Boolean authenticate(LoginInputData loginInputData) throws AuthenticationException {
        // Create a ClaimsExaminer object from the username's equivalent in the database'
        Optional<ClaimsExaminer> optionalExaminer = examinerRepository.findByUsername(loginInputData.getUsername());
        if (optionalExaminer.isPresent()){
            ClaimsExaminer examiner = optionalExaminer.get();
            // get the password from the ClaimsExaminer object
            String dbPassword = examiner.getPassword();

            // compare database value to the password in the loginInputData
            if (dbPassword.equals(loginInputData.getPassword())) {
                System.out.println("Successful login.");
                return true;
            } else {
                // if password doesn't match for user, throw authentication exception
                throw new AuthenticationException("Invalid credentials.");

            }
        }
        // if username doesn't exist in the database, throw authentication exception
        throw new AuthenticationException("Incorrect credentials.");

    }
}

