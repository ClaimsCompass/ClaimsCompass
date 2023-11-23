package com.securian.creditcompass.ClaimState;

import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;
import com.securian.creditcompass.login.LoginRepository;

import java.util.List;

// TODO: Use NewClaimState in the right place; when new claim is added (guess this is out of our scope, use in test?)
// Or actually we will know a new claim is added if its ClaimState is NewClaimState. At the start of the program,
// we can check all claims and assign them to examiners. Of course, automatically, assignment should not happen for all.

public class NewClaimState implements ClaimState {

    private final LoginRepository loginRepository;

    // Add constructor
    public NewClaimState(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void assignToClaimsExaminer(ClaimsExaminer examiner, Claim claim) {
        // Logic specific to assigning a claim in the 'New' state
        // For a new claim, assign to the examiner with the lowest score
        List<ClaimsExaminer> examiners = loginRepository.findAll();
        ClaimsExaminer minExaminer = claim.getExaminerWithMinScore(examiners);
        minExaminer.getClaims().add(claim);
        System.out.println("Claim assigned to examiner with lowest score.");
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
