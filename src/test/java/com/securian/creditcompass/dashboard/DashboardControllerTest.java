package com.securian.creditcompass.dashboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.mockito.BDDMockito.given;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class DashboardControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DashboardInteractor dashboardInteractor;

    @Test
    public void whenExecuteCalled_thenReturnCorrectData() throws Exception {
        // Arrange
        String username = "janeDoe";
        Boolean isProcessed = false;
        List<List<Object>> mockResponse = List.of(List.of(List.of(998, 100000f, "2023-12-06T00:44:39.114896", "disability", "Low", "Low"),
                List.of(999, 120000f, "2023-12-06T00:44:39.114896","life", "Low", "Low")));
        given(dashboardInteractor.execute(new DashboardInputData(username, isProcessed))).willReturn(mockResponse);

        // Act & Assert
        mvc.perform(MockMvcRequestBuilders
                        .post("/api/claims")
                        .param("username", username)
                        .param("isProcessed", isProcessed.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists()) //need to add expected response data
                .andDo(print());
    }

}
