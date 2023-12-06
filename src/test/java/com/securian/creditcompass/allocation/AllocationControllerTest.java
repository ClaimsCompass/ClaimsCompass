package com.securian.creditcompass.allocation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AllocationControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void execute() throws Exception {
        // perform the post request to /assign endpoint and check that the status code is 200
        // also check that the response body is "true" to signify if the controller method executes successfully
        mvc.perform(post("/assign")).andExpect(status().isOk())
                .andExpect(content().string("true"));


    }
}