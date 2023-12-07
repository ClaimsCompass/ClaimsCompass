package com.securian.creditcompass.multiLayerPerceptron.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MLPModelTest {

    private MLPModel mlpModel;

    @BeforeEach
    public void setUp() {
        mlpModel = new MLPModel();
    }

    @Test
    public void testPredictComplexity() {
        // Define test input
        double[][] testInput = {{100000, 0, 0, 0, 2, 0}};

        // Perform prediction
        int predictedComplexity = MLPModel.predictComplexity(testInput);

        // Define the expected output for the given test input
        int expectedComplexity = 2; // Adjust this based on your expectations

        // Assert the predicted output matches the expected output
        assertEquals(expectedComplexity, predictedComplexity, "Predicted complexity doesn't match");
    }
}
