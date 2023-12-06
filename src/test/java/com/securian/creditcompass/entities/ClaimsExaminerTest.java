package com.securian.creditcompass.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClaimsExaminerTest {
    private ClaimsExaminer testExaminer;

    @BeforeEach
    void setUp() {
        testExaminer = new ClaimsExaminer("janeDoe", "passcode", "jane", 123L);
    }

    @Test
    void getUsername() {
        assertEquals("janeDoe", testExaminer.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("passcode", testExaminer.getPassword());
    }

    @Test
    void getFirstName() {
        assertEquals("jane", testExaminer.getFirstName());
    }

    @Test
    void getId() {
        assertEquals(123L, testExaminer.getId());
    }

    @Test
    void setUsername() {
        testExaminer.setUsername("johnDoe");
        assertEquals("johnDoe", testExaminer.getUsername());
    }

    @Test
    void setPassword() {
        testExaminer.setPassword("newPasscode");
        assertEquals("newPasscode", testExaminer.getPassword());
    }

    @Test
    void setFirstName() {
        testExaminer.setFirstName("john");
        assertEquals("john", testExaminer.getFirstName());
    }

    @Test
    void setId() {
        testExaminer.setId(456L);
        assertEquals(456L, testExaminer.getId());
    }
}