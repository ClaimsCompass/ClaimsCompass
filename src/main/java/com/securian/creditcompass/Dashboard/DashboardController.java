package com.securian.creditcompass.Dashboard;

import com.securian.creditcompass.OrderCalculator.OrderCalculator;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.securian.creditcompass.Dashboard.ClaimAssignerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<List<Object>> getAllSortedClaims(@RequestParam String username) {
        ClaimAssigner claimAssigner = new ClaimAssigner();
        Optional<List<Claim>> claims = dashboardRepository.findClaimsByExaminer();
        List<ClaimsExaminer> examiners = claimAssignerRepository.findAll();
        if (claims.isPresent()) {
            claimAssigner.assignAllClaims(examiners, claims.get());
            OrderCalculator scoredClaims = new OrderCalculator(claims.get());
            List<Claim> sortedClaims = scoredClaims.getOrderedClaims();
            return renderDashboardService.findAttributes(sortedClaims);
        } else {
            return new ArrayList<>();
        }

    }
}