package com.securian.creditcompass.allocation;

import com.securian.creditcompass.dashboard.DashboardRepository;
import com.securian.creditcompass.dashboard.RenderDashboardService;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;

public class AllocationController {
    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    public void execute(){
        allocationService.assignAllClaims();
    }
}
