package com.securian.creditcompass.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.swing.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mvc; // will allow to mock out mvc objects

    @Test
    void testLoginSuccessful() throws Exception {
        // SETUP
        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .content("{\"username\":\"janeDoe\",\"password\":\"hello\"}")
                .contentType("application/json");
        // Perform post request to /login endpoint, which invokes the login method in LoginController
        MvcResult result = mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
        String responseEntity = result.getResponse().getContentAsString();

        //ASSERT
        assertThat(responseEntity).contains("Logging you in...");
    }

    @Test
    void testInvalidCredentials() throws Exception {
        // SETUP
        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .content("{\"username\":\"janeDoe\",\"password\":\"wrongPassword\"}")
                .contentType("application/json");
        // Perform post request to /login endpoint, which invokes the login method in LoginController
        MvcResult result = mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(status().isUnauthorized()).andReturn();
        String responseEntity = result.getResponse().getContentAsString();

        //ASSERT
        assertThat(responseEntity).contains("Invalid credentials.");
    }

    @Test
    void testIncorrectCredentials() throws Exception {
        // SETUP
        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .content("{\"username\":\"wrongUsername\",\"password\":\"hello\"}")
                .contentType("application/json");
        // Perform post request to /login endpoint, which invokes the login method in LoginController
        MvcResult result = mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(status().isUnauthorized()).andReturn();
        String responseEntity = result.getResponse().getContentAsString();

        //ASSERT
        assertThat(responseEntity).contains("Incorrect credentials.");
    }
}