package com.securian.creditcompass;

public class AssignedClaimState implements ClaimState {
    @Override
    public void assignToClaimsExaminer(ClaimsExaminer examiner, Claim claim) {
        // Logic specific to assigning a claim in the 'Assigned' state
        System.out.println("Cannot assign a claim that is already assigned.");
    }

    @Override
    public void calculateScore(Claim claim) {
        // Logic specific to calculating a score for a claim in the 'Assigned' state
        System.out.println("Cannot calculate scores for a claim that is already assigned.");
    }

    @Override
    public void processClaim(Claim claim) {
        // Logic specific to processing a claim in the 'Assigned' state
        claim.processClaim();
        System.out.println("Claim processed.");
    }
}
