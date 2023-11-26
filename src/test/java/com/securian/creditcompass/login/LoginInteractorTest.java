package com.securian.creditcompass.login;

import com.securian.creditcompass.entities.ClaimsExaminer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.naming.AuthenticationException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginInteractorTest {
    @Mock
    private LoginDataAccessInterface loginDataAccessInterface;
    @InjectMocks
    // injects all mocks into LoginInteractor object
    private LoginInteractor loginInteractor;

    @BeforeEach
    void setUp() {
        // instantiate new LoginInteractor object before each test
        loginInteractor = new LoginInteractor(loginDataAccessInterface);
    }

    @Test
    void testAuthenticateSuccess() throws AuthenticationException {
        //GIVEN
        // setting up the instance input param
        LoginInputData loginInputData = new LoginInputData("janeDoe", "passcode");
        // creating a stub for call to database
        Optional<ClaimsExaminer> stubExaminer = Optional.of(new ClaimsExaminer("janeDoe", "passcode", "jane", 123L));
        // when the findByUsername method is called, return the stub
        when(loginDataAccessInterface.findByUsername("janeDoe")).thenReturn(stubExaminer);

        //WHEN METHOD CALLED
        boolean responseSuccess = loginInteractor.authenticate(loginInputData);
        //ASSERT
        assertThat(responseSuccess).isTrue();
    }

    @Test
    void testWrongPasswordThrowsException() {
        //GIVEN
        // setting up the instance input param
        LoginInputData loginInputData = new LoginInputData("janeDoe", "passcode");
        // creating a stub for call to database
        Optional<ClaimsExaminer> stubExaminer = Optional.of(new ClaimsExaminer("janeDoe", "wrongPassword", "jane", 123L));
        // when the findByUsername method is called, return the stub
        when(loginDataAccessInterface.findByUsername("janeDoe")).thenReturn(stubExaminer);

        //ASSERT
        // here using Assertions.assertThrows to test that method throws an AuthenticationException only
        AuthenticationException thrownInvalid = assertThrows(AuthenticationException.class, () -> loginInteractor.authenticate(loginInputData));
        assertEquals("Invalid credentials.", thrownInvalid.getMessage());
    }

    @Test
    void testExaminerNotFoundThrowsException() {
        //GIVEN
        // setting up the instance input param
        LoginInputData loginInputData = new LoginInputData("janeDoe", "passcode");

        // Call to database should return null value, optionalExaminer.isPresent() will be false
        when(loginDataAccessInterface.findByUsername("janeDoe")).thenReturn(Optional.empty());

        // ASSERT
        AuthenticationException thrownIncorrect = assertThrows(AuthenticationException.class, () -> loginInteractor.authenticate(loginInputData));
        assertEquals("Incorrect credentials.", thrownIncorrect.getMessage());
    }
}