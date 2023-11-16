package com.securian.creditcompass.Dashboard;

import com.securian.creditcompass.entities.Claim;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DashboardController {

    private final DashboardRepository dashboardRepository;

    public DashboardController(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    @GetMapping("/api/claims") // API endpoint to get all claims
    public List<Claim> getAllClaims() {
        return dashboardRepository.findAll();
    }

    // Other API endpoints for CRUD operations, filtering, etc.
}