package com.securian.creditcompass.dashboard;

import com.securian.creditcompass.dataAccess.ClaimRepository;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.orderCalculator.OrderCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DashboardInteractorTest {

    @InjectMocks
    private DashboardInteractor dashboardInteractor;

    @Mock
    private ClaimRepository claimRepository;

    @Mock
    private OrderCalculator orderCalculator;

    @BeforeEach
    void setUp() {
        dashboardInteractor = new DashboardInteractor(claimRepository, orderCalculator);
    }

    @Test
    void testCorrectDataReturned() {
        DashboardInputData inputData = new DashboardInputData("janeDoe", false);
        List<List<Object>> expectedOutput = List.of(List.of(998, 100000f, "2023-12-06T00:44:39.114896", "disability", "Low", "Low"),
                List.of(999, 120000f, "2023-12-06T00:44:39.114896","life", "Low", "Low"));

        Claim stubClaim = new Claim(999,"life", "Life", 120000f, 0, 0);
        Claim stubClaim2 = new Claim(998,"disability", "Disability", 100000f, 0, 0);

        List<Claim> stubClaims = List.of(stubClaim, stubClaim2);

        when(claimRepository.findByExaminer("janeDoe")).thenReturn(Optional.of(stubClaims));
        when(orderCalculator.orderClaims(stubClaims)).thenReturn(List.of(stubClaim2, stubClaim));

        List<List<Object>> actualOutput = dashboardInteractor.execute(inputData);

        // Create mutable copies of the lists
        List<List<Object>> expectedOutputMutable = expectedOutput.stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());
        List<List<Object>> actualOutputMutable = actualOutput.stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());

        // Set date-time to null since it's dynamic
        expectedOutputMutable.forEach(list -> list.set(2, null));
        actualOutputMutable.forEach(list -> list.set(2, null));

        // Assert
        assertEquals(expectedOutputMutable, actualOutputMutable);
    }

    @Test
    void testDatabaseUpdate() {

        DashboardInputData inputData = new DashboardInputData("janeDoe", false);
        List<List<Object>> expectedOutput = List.of(List.of(998, 100000f, "2023-12-06T00:44:39.114896", "disability", "Low", "Low"),
                List.of(999, 120000f, "2023-12-06T00:44:39.114896","life", "Low", "Low"));

        Claim stubClaim = new Claim(999,"life", "Life", 120000f, 0, 0);
        Claim stubClaim2 = new Claim(998,"disability", "Disability", 100000f, 0, 0);

        List<Claim> stubClaims = List.of(stubClaim2, stubClaim);

        when(claimRepository.findByExaminer("janeDoe")).thenReturn(Optional.of(stubClaims));
        when(orderCalculator.orderClaims(stubClaims)).thenReturn(List.of(stubClaim2, stubClaim));

        List<List<Object>> actualOutput = dashboardInteractor.execute(inputData);

        // Assert
        verify(claimRepository, times(1)).saveAll(stubClaims);
    }
}
