package com.securian.creditcompass.orderCalculator;

import com.securian.creditcompass.entities.Claim;

public class ComplexityCalculator {
    private final ComplexityAlgorithm complexityAlgorithm;

    public ComplexityCalculator(ComplexityAlgorithm complexityAlgorithm) {
        this.complexityAlgorithm = complexityAlgorithm;
    }

    public int calculateComplexity(Claim claim) {
        return complexityAlgorithm.calculateComplexity(claim);
    }
}

