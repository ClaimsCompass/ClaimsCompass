package com.securian.creditcompass.orderCalculator;

import com.securian.creditcompass.entities.Claim;

public interface ComplexityAlgorithm {
    public int calculateComplexity(Claim claim);
}
