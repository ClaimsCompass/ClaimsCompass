package com.securian.creditcompass.Dashboard;

import com.securian.creditcompass.OrderCalculator.OrderCalculator;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securian.creditcompass.Dashboard.ClaimAssignerRepository;

import java.util.List;

@RestController
public class DashboardController {
    private final RenderDashboardService renderDashboardService;

    private final DashboardRepository dashboardRepository;

    private final ClaimAssignerRepository claimAssignerRepository;

    public DashboardController(RenderDashboardService renderDashboardService, DashboardRepository dashboardRepository, ClaimAssignerRepository claimAssignerRepository) {
        this.renderDashboardService = renderDashboardService;
        this.dashboardRepository = dashboardRepository;
        this.claimAssignerRepository = claimAssignerRepository;
    }

    @GetMapping("/api/claims") // API endpoint to get all claims
    public List<List<Object>> getAllSortedClaims() {
        ClaimAssigner claimAssigner = new ClaimAssigner();
        List<Claim> claims = dashboardRepository.findAll();
        List<ClaimsExaminer> examiners = claimAssignerRepository.findAll();
        claimAssigner.assignAllClaims(examiners, claims);
        OrderCalculator scoredClaims = new OrderCalculator(claims);
        List<Claim> sortedClaims = scoredClaims.getOrderedClaims();
        return renderDashboardService.findAttributes(sortedClaims);
    }
}