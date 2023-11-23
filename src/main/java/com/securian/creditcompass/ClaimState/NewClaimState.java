package com.securian.creditcompass.ClaimState;

import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;

import java.util.Collections;
import java.util.List;

public class NewClaimState implements ClaimState {

    public <claimsExaminer> void assignToClaimsExaminer(Claim claim, List<claimsExaminer> examiners) {
        // Assign the claim to a claims examiner
        claim.assignToClaimsExaminer((ClaimsExaminer) examiners);
    }


    @Override
    public void assignToClaimsExaminer(ClaimsExaminer examiner, Claim claim) {

    }

    @Override
    public void calculateScore(Claim claim) {
        // Calculate score logic for a new claim
        int complexityScore = claim.getComplexityScore();
        int urgencyScore = claim.getUrgencyScore();

        claim.setComplexityScore(complexityScore);
        claim.setUrgencyScore(urgencyScore);

        claim.getTotalScore();

        System.out.println("Scores calculated for the new claim.");
    }

    @Override
    public void changeToProcessed(Claim claim) {
        // Logic specific to processing a claim in the 'New' state
        // For a new claim, processing may not involve any action
        System.out.println("Cannot process a claim that is still new.");
    }
}
