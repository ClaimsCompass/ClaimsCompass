package com.securian.creditcompass.ClaimState;

import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;

public class AssignedClaimState implements ClaimState {
    @Override
    public void assignToClaimsExaminer(ClaimsExaminer<?> examiner, Claim claim) {
        // Logic specific to assigning a claim in the 'Assigned' state
        System.out.println("Cannot assign a claim that is already assigned.");
    }

    @Override
    public void calculateScore(Claim claim) {
        // Logic specific to calculating a score for a claim in the 'Assigned' state
        int complexityScore = claim.getComplexityScore();
        int urgencyScore = claim.getUrgencyScore();

        claim.setComplexityScore(complexityScore);
        claim.setUrgencyScore(urgencyScore);

        claim.getTotalScore();

        System.out.println("Scores calculated for the new claim.");
    }

    @Override
    public void changeToProcessed(Claim claim) {
        // Logic specific to processing a claim in the 'Assigned' state
        claim.processClaim();
        System.out.println("Claim processed.");
    }
}

