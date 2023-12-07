package com.securian.creditcompass.useCases.claimPage;

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
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClaimPageControllerTest {

    @Autowired
    private MockMvc mvc; // will allow to mock out mvc objects

    @Test
    void getClaimById() throws Exception {
        // SET UP a get request to /api/getClaimById endpoint
        // with a body of {"id":1}
        // and a content type of application/json
        RequestBuilder request = MockMvcRequestBuilders.get("/api/getClaimById")
                .param("id", "10") // id should be in database for test to pass
                .contentType("application/json");

        // Perform get request to /api/getClaimById endpoint, which invokes the getClaimById method in ClaimPageController
        MvcResult result = mvc.perform(request)
                .andDo(MockMvcResultHandlers.print()) // prints the response
                .andExpect(status().isOk()) // checks that the status code is 200 i.e. request is successful
                .andExpect(jsonPath("$.id").value(10))
                // above line checks that the id of the claim mapped to JSON is 10
                .andExpect(jsonPath("$").isMap())
                .andReturn();
        String responseJson = result.getResponse().getContentAsString();

        //ASSERT
        assertThat(responseJson).contains("10");
    }

    @Test
    void updateProcessedClaim() throws Exception {
        // SET UP a post request to /api/updateProcessedClaim endpoint
        // with a body of {"id":1}
        // and a content type of application/json
        RequestBuilder request = MockMvcRequestBuilders.post("/api/updateProcessedClaim")
                .param("id", "1") // id should be in database for test to pass
                .contentType("application/json");

        // Perform post request to /api/updateProcessedClaim endpoint,
        // which invokes the updateProcessedClaim method in ClaimPageController
        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk()) // checks that the status code is 200 i.e. request is successful
                .andReturn();

    }
}