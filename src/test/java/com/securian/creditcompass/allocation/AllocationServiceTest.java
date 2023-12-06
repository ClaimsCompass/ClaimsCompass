package com.securian.creditcompass.allocation;

import com.securian.creditcompass.dataAccess.ClaimRepository;
import com.securian.creditcompass.dataAccess.ExaminerRepository;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AllocationServiceTest {
    @Mock
    private ExaminerRepository examinerRepository;
    @Mock
    private ClaimRepository claimRepository;
    private ClaimsExaminer janeDoe;
    private ClaimsExaminer johnDoe;
    private List<ClaimsExaminer> claimsExaminers;
    private Claim claimMock;
    private Claim claimMock2;
    private List<Claim> claims;
    @InjectMocks
    private AllocationService allocationService;

    @BeforeEach
    void setUp() {
        // instantiate new AllocationService object before each test
        allocationService = new AllocationService(examinerRepository, claimRepository);
        // a Mock list of claim examiners
        janeDoe = new ClaimsExaminer("janeDoe", "passJane", "jane", 12L);
        johnDoe = new ClaimsExaminer("johnDoe", "passJohn", "john", 13L);
        claimsExaminers = new ArrayList<>();
        claimsExaminers.add(janeDoe);
        claimsExaminers.add(johnDoe);

        // a mock Claim object
        claimMock = new Claim(10, "unemployment", "details from form", 10000F, 6, 4);
        claimMock2 = new Claim(11, "unemployment", "details from form", 7000F, 6, 0);
        claims = new ArrayList<>();
        claims.add(claimMock);
        claims.add(claimMock2);

    }

    @Test
    void assignClaimDoesNotAssignClaimIfAlreadyAssigned() {
        // Checks that assignClaim does not assign a claim if it is already assigned to an examiner

        // GIVEN claim is already assigned to an examiner
        claimMock.setExaminerByUsername("janeDoe");
        // WHEN method called
        allocationService.assignClaim(claimMock, claimsExaminers);
        // THEN assert and verify
        assertNotNull(claimMock.getExaminer());
        verify(claimRepository, never()).save(any(Claim.class));
    }

    @Test
    void assignClaimSetsAssignedExaminer() {
        // Checks that assignClaim sets the examiner column of the claim to the assigned examiner

        // WHEN method called
        allocationService.assignClaim(claimMock, claimsExaminers);
        // THEN assert and verify
        assertEquals(janeDoe.getUsername(), claimMock.getExaminer());
    }

    @Test
    void assignClaimSavesNewClaimToDB() {
        // Checks that assignClaim saves the claim to the database

        // WHEN method called
        allocationService.assignClaim(claimMock, claimsExaminers);

        // THEN assert and verify
        verify(claimRepository).save(claimMock);
    }

    @Test
    void assignsAllClaims() {
        // Checks that assignAllClaims actually assigns all the claims in the database

        when(claimRepository.findAll()).thenReturn(claims);
        when(examinerRepository.findAll()).thenReturn(claimsExaminers);

        allocationService.assignAllClaims();
        // verify that assignClaim is called n number of times, where n is the number of claims
        verify(claimRepository, times(claims.size())).save(any(Claim.class));
    }

    @Test
    void getExaminerScoreGivesCorrectTotalScore() {
        // Verifies that getExaminerScore returns the correct total score of all claims assigned to particular examiner

        ClaimsExaminer currExaminer = janeDoe;
        when(claimRepository.findClaimsByExaminer(currExaminer.getUsername())).thenReturn(claims);

        int totalScoreTest = allocationService.getExaminerScore(currExaminer);
        assertEquals(16, totalScoreTest);

    }
}
