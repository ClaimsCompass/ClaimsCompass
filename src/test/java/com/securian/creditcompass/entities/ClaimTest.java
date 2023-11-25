package com.securian.creditcompass.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClaimTest {
    private Claim test_claim;

    @BeforeEach
    void init(){
        test_claim = new Claim(1234, "Death", "death due to car accident.", 10000.00F, 4, 2);
    }

    @Test
    void getId() {
        assertEquals(1234, test_claim.getId());
    }

    @Test
    void getClaimType() {
        assertEquals("Death", test_claim.getClaimType());
    }

    @Test
    void getClaimDetails() {
        assertEquals("death due to car accident.", test_claim.getClaimDetails());
    }

    @Test
    void getClaimAmt() {
        // should I add a delta? If so, what should the error range for the float be?
        assertEquals(10000.00F, test_claim.getClaimAmt());
    }

    @Test
    void getComplexityScore() {
        assertEquals(4, test_claim.getComplexityScore());
    }

    @Test
    void getUrgencyScore() {
        assertEquals(2, test_claim.getUrgencyScore());
    }

    @Test
    void setComplexityScore() {
        test_claim.setComplexityScore(5);
        assertEquals(5, test_claim.getComplexityScore());
    }

    @Test
    void setUrgencyScore() {
        test_claim.setUrgencyScore(3);
        assertEquals(3, test_claim.getUrgencyScore());
    }

    @Test
    void setTotalScore() {
        test_claim.setTotalScore(10);
        assertEquals(10, test_claim.getTotalScore());
    }

    @Test
    void getTotalScore() {
        test_claim.setTotalScore(10);
        assertEquals(10, test_claim.getTotalScore());
    }

    @Test
    void isProcessed() {
        assertFalse(test_claim.isProcessed());
    }

    @Test
    void processClaim() {
        test_claim.processClaim();
        assertTrue(test_claim.isProcessed());
    }
}