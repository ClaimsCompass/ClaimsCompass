package com.securian.creditcompass.login;

import javax.naming.AuthenticationException;

public interface LoginInputBoundary {
    Boolean authenticate(LoginInputData loginInputData) throws AuthenticationException;
}
