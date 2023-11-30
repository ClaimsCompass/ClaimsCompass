package com.securian.creditcompass.Dashboard;

import com.securian.creditcompass.OrderCalculator.OrderCalculator;
import com.securian.creditcompass.entities.Claim;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class DashboardController {
    private final RenderDashboardService renderDashboardService;

    private final DashboardRepository dashboardRepository;

    public DashboardController(RenderDashboardService renderDashboardService, DashboardRepository dashboardRepository) {
        this.renderDashboardService = renderDashboardService;
        this.dashboardRepository = dashboardRepository;
    }

    @GetMapping("/api/activeClaims") // API endpoint to get all claims
    public List<List<Object>> getAllSortedClaims() {
        System.out.println("Hello");
        List<Claim> claims = dashboardRepository.findAll();
        OrderCalculator scoredClaims = new OrderCalculator(claims);
        List<Claim> sortedClaims = scoredClaims.getOrderedClaims();

        ArrayList<Claim> filteredClaims = new ArrayList<Claim>();
        for (int i = 0; i < sortedClaims.size(); i++) {
            if (!sortedClaims.get(i).isProcessed()) {
                filteredClaims.add(sortedClaims.get(i));
            }
        }
        return renderDashboardService.findAttributes(filteredClaims);
    }

    @GetMapping("/api/processedClaims") // API endpoint to get all claims
    public List<List<Object>> getAllSortedProcessedClaims() {
        List<Claim> claims = dashboardRepository.findAll();
        OrderCalculator scoredClaims = new OrderCalculator(claims);
        List<Claim> sortedClaims = scoredClaims.getOrderedClaims();

        ArrayList<Claim> filteredClaims = new ArrayList<Claim>();
        for (int i = 0; i < sortedClaims.size(); i++) {
            if (sortedClaims.get(i).isProcessed()) {
                filteredClaims.add(sortedClaims.get(i));
            }
        }
        return renderDashboardService.findAttributes(filteredClaims);
    }


    @GetMapping("/api/getClaimById") // API endpoint to get a single claim by id
    public Claim getClaimById(@RequestParam Integer id) {
        Optional<Claim> maybeClaim = dashboardRepository.findById(id);

        if (maybeClaim.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ClaimID not found.");
        }
        return maybeClaim.get();
    }

    @PostMapping("/api/updateProcessedClaim") // POST mapping to indicate that a claim has been processed
    public void updateProcessedClaim(@RequestParam Integer id) {
        Optional<Claim> maybeClaim = dashboardRepository.findById(id);

        if (maybeClaim.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ClaimID not found.");
        }

        Claim claim = maybeClaim.get();
        claim.processClaim();
        dashboardRepository.save(claim);

        // return a 200 status code here
    }
}