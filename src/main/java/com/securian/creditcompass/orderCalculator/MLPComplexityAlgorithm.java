package com.securian.creditcompass.orderCalculator;

import com.securian.creditcompass.entities.Claim;

import java.util.Objects;

public class MLPComplexityAlgorithm implements ComplexityAlgorithm{
    /*
    This class will only be used once we are able to train the MLP beyond the proof of concept stage.
    */
    @Override
    public int calculateComplexity(Claim claim) {
        /*
        @param claim: the claim to calculate the complexity of
        @return: the complexity of the claim
         */
        float exactClaimAmount = claim.getClaimAmount();
        int claimAmount = Math.round(exactClaimAmount);
        // Changed type to allow for use of arrays later on, which will simplify things.

        String claimType = claim.getClaimType();
        int partyA = 0;
        int partyB = 0;
        int partyC = 0;

        // These are placeholder assumptions for proof of concept for this algorithm.
        // If we had access to real data on when exactly each party is involved, we would not have these placeholders.
        if (Objects.equals(claimType, "Health")) {
            partyA = 1;
        } else if (claimAmount > 100000) {
            partyB = 1;
            partyC = 1;
        }

        // We assume for now that we are calculating complexity for the average examiner
        // In the future, we should make changes to calculate complexity relative to an examiner.
        int examinerSeniorityLevel = 1;
        return 0;
    }
}
