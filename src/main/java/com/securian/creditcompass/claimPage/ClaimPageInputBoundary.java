package com.securian.creditcompass.claimPage;
import com.securian.creditcompass.entities.Claim;

import java.util.List;

public interface ClaimPageInputBoundary {
    void execute_post(ClaimPageInputData dashboardInputData);
    Claim execute_get(ClaimPageInputData dashboardInputData);
}
