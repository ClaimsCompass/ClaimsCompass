package com.securian.creditcompass.useCases.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mvc; // will allow to mock out mvc objects

    @Test
    void testLoginSuccessful() throws Exception {

        // SET UP a post request to /login endpoint
        // with a body of {"username":"janeDoe","password":"hello"} NOTE: all details should match database
        // and a content type of application/json
        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .content("{\"username\":\"janeDoe\",\"password\":\"Maison\"}")
                .contentType("application/json");

        // Perform post request to /login endpoint, which invokes the login method in LoginController

        // andDo(MockMvcResultHandlers.print()) prints the response i.e the ResponseEntity to the console
        // andExpect(status().isOk()) checks that the status code is 200
        MvcResult result = mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
        // get the response body as a string
        String responseEntity = result.getResponse().getContentAsString();

        //ASSERT
        assertThat(responseEntity).contains("Logging you in...");
    }

    @Test
    void testInvalidCredentials() throws Exception {
        // SETUP
        // NOTE: username should exist in database but password should be wrong
        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .content("{\"username\":\"janeDoe\",\"password\":\"wrongPassword\"}")
                .contentType("application/json");

        // Perform post request to /login endpoint, which invokes the login method in LoginController
        // andExpect(status().isUnauthorized()) checks that the status code is 401
        MvcResult result = mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(status().isUnauthorized()).andReturn();
        String responseEntity = result.getResponse().getContentAsString();

        //ASSERT
        assertThat(responseEntity).contains("Invalid credentials.");
    }

    @Test
    void testIncorrectCredentials() throws Exception {
        // SETUP
        // NOTE: username should not exist in database, password is a Don't Care
        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .content("{\"username\":\"wrongUsername\",\"password\":\"hello\"}")
                .contentType("application/json");

        // Perform post request to /login endpoint, which invokes the login method in LoginController
        // andExpect(status().isUnauthorized()) checks that the status code is 401
        MvcResult result = mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(status().isUnauthorized()).andReturn();
        String responseEntity = result.getResponse().getContentAsString();

        //ASSERT
        assertThat(responseEntity).contains("Incorrect credentials.");
    }
}