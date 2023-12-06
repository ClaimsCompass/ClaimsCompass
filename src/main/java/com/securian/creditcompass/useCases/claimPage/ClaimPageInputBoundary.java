package com.securian.creditcompass.useCases.claimPage;
import com.securian.creditcompass.entities.Claim;

public interface ClaimPageInputBoundary {
    void execute_post(ClaimPageInputData dashboardInputData);
    Claim execute_get(ClaimPageInputData dashboardInputData);
}
