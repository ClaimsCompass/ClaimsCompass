package com.securian.creditcompass.orderCalculator;

import com.securian.creditcompass.entities.Claim;

public class ComplexityCalculator {
    private ComplexityAlgorithm complexityAlgorithm;

    public ComplexityCalculator(ComplexityAlgorithm complexityAlgorithm) {
        /*
        @param complexityAlgorithm: the algorithm used to calculate the complexity of a claim
        */
        this.complexityAlgorithm = complexityAlgorithm;
    }

    public int calculateComplexity(Claim claim) {
        /*
        @param claim: the claim to calculate the complexity of
        @return: the complexity of the claim
         */
        return complexityAlgorithm.calculateComplexity(claim);
    }

    public void setComplexityAlgorithm(ComplexityAlgorithm complexityAlgorithm){
        /*
        @param complexityAlgorithm: the algorithm used to calculate the complexity of a claim
         */
        this.complexityAlgorithm = complexityAlgorithm;
    }
}



