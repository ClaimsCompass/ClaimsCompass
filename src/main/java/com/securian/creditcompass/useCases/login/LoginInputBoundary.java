package com.securian.creditcompass.useCases.login;

import javax.naming.AuthenticationException;

public interface LoginInputBoundary {
    Boolean authenticate(LoginInputData loginInputData) throws AuthenticationException;
}
