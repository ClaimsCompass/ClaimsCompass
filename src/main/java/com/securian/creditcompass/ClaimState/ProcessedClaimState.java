package com.securian.creditcompass.ClaimState;

import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;

public class ProcessedClaimState implements ClaimState {
    @Override
    public void assignToClaimsExaminer(ClaimsExaminer<T> examiner, Claim claim) {
        // Logic specific to assigning a claim in the 'Processed' state
        System.out.println("Cannot assign a claim that is already processed.");
    }

    @Override
    public void calculateScore(Claim claim) {
        // Logic specific to calculating a score for a claim in the 'Processed' state
        System.out.println("Cannot calculate scores for a claim that is already processed.");
    }

    @Override
    public void changeToProcessed(Claim claim) {
        // Logic specific to processing a claim in the 'Processed' state
        System.out.println("Cannot process a claim that is already processed.");
    }
}
