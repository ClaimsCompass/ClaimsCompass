package com.securian.creditcompass;

public class NewClaimState implements ClaimState {
    @Override
    public void assignToClaimsExaminer(ClaimsExaminer examiner, Claim claim) {
        // Assign the claim to the provided claims examiner
        examiner.assignClaim(claim);
        System.out.println("Claim assigned to claims examiner: " + examiner.getFirstName());
    }

    @Override
    public void calculateScore(Claim claim) {
        // Calculate score logic for a new claim
        int complexityScore = claim.getComplexityScore();
        int urgencyScore = claim.getUrgencyScore();

        claim.setComplexityScore(complexityScore);
        claim.setUrgencyScore(urgencyScore);

        claim.calculateTotalScore();

        System.out.println("Scores calculated for the new claim.");
    }

    @Override
    public void processClaim(Claim claim) {
        // Logic specific to processing a claim in the 'New' state
        // For a new claim, processing may not involve any action
        System.out.println("Cannot process a claim that is still new.");
    }
}
