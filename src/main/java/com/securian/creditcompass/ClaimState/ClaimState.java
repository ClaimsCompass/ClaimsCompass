package com.securian.creditcompass.ClaimState;

import com.securian.creditcompass.Claim;
import com.securian.creditcompass.ClaimsExaminer;

public interface ClaimState {
    void assignToClaimsExaminer(ClaimsExaminer examiner, Claim claim);
    void calculateScore(Claim claim);
    void changeToProcessed(Claim claim);
}



