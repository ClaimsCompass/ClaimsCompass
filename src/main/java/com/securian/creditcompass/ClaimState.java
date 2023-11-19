package com.securian.creditcompass;

public interface ClaimState {
    void assignToClaimsExaminer(ClaimsExaminer examiner, Claim claim);
    void calculateScore(Claim claim);
    void processClaim(Claim claim);
}
