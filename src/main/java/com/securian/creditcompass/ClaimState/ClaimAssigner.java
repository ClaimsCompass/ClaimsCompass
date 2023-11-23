package com.securian.creditcompass.ClaimState;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;

import java.util.List;

// Facade Implementation
public class ClaimAssigner {
    public void assignClaim(List<ClaimsExaminer> examiners, Claim nextClaim) {
        // assign the claim to this examiner with the lowest score
        ClaimsExaminer minExaminer = nextClaim.getExaminerWithMinScore(examiners);
        minExaminer.getClaims().add(nextClaim);
    }
}
