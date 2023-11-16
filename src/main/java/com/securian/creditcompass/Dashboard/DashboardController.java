package com.securian.creditcompass.Dashboard;

import com.securian.creditcompass.OrderCalculator.OrderCalculator;
import com.securian.creditcompass.entities.Claim;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DashboardController {
    private final RenderDashboardService renderDashboardService;

    private final DashboardRepository dashboardRepository;

    public DashboardController(RenderDashboardService renderDashboardService, DashboardRepository dashboardRepository) {
        this.renderDashboardService = renderDashboardService;
        this.dashboardRepository = dashboardRepository;
    }

    @GetMapping("/api/claims") // API endpoint to get all claims
    public List<List<Object>> getAllSortedClaims() {
        System.out.println("Hey");
        List<Claim> claims = dashboardRepository.findAll();
        System.out.println(claims.get(0).getClaimType());
        System.out.println(claims.get(0).getClaimDetails());
        System.out.println("Hi");
//        OrderCalculator scoredClaims = new OrderCalculator(claims);
//        List<Claim> sortedClaims = scoredClaims.getOrderedClaims();
        return renderDashboardService.findAttributes(claims);
    }
}