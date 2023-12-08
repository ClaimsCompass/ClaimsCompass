package com.securian.creditcompass.useCases.claimPage;

import com.securian.creditcompass.dataAccess.ClaimRepository;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.orderCalculator.OrderCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ClaimPageInteractorTest {

    @Mock
    private ClaimRepository claimRepository;

    @Mock
    private OrderCalculator orderCalculator;

    @InjectMocks
    private ClaimPageInteractor claimPageInteractor;

    private ClaimPageInputData validInputData;
    private ClaimPageInputData invalidInputData;
    private Claim validClaim;

    @BeforeEach
    void setUp() {
        validInputData = new ClaimPageInputData(999L, false); //this claim should be in the db
        invalidInputData = new ClaimPageInputData(123L, true);
        validClaim = mock(Claim.class); // Create a mock Claim

        lenient().when(claimRepository.findById(validInputData.claimId)).thenReturn(Optional.of(validClaim));
        lenient().when(claimRepository.findById(invalidInputData.claimId)).thenReturn(Optional.empty());
    }

    @Test
    void testExecutePostWithValidClaimThenSaveUpdatedClaim() {
        // Act
        claimPageInteractor.execute_post(validInputData);

        // Assert
        verify(validClaim).processClaim();
        verify(claimRepository).save(validClaim);
    }

    @Test
    void testExecutePostWithInvalidClaimThenThrowException() {
        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> claimPageInteractor.execute_post(invalidInputData));
    }

    @Test
    void testExecuteGetWithValidClaimThenReturnClaim() {
        // Act
        Claim actualClaim = claimPageInteractor.execute_get(validInputData);

        // Assert
        assertEquals(validClaim, actualClaim);
    }

    @Test
    void testExecuteGetWithInvalidClaimThenThrowException() {
        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> claimPageInteractor.execute_get(invalidInputData));
    }
}
