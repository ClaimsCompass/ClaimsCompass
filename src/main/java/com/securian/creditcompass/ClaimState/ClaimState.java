package com.securian.creditcompass.ClaimState;

import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;

public interface ClaimState {
    void assignToClaimsExaminer(ClaimsExaminer<T> examiner, Claim claim);
    void calculateScore(Claim claim);
    void changeToProcessed(Claim claim);
}
