package com.securian.creditcompass.dashboard;
import com.securian.creditcompass.Dashboard.DashboardInteractor
import com.securian.creditcompass.dataAccess.ExaminerRepository;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DashboardController {
    private final DashboardInteractor dashboardInteractor;

    private final ExaminerRepository examinerRepository;

//    private final AllocationRepository claimAssignerRepository;

    public DashboardController(DashboardInteractor dashboardInteractor, ExaminerRepository examinerRepository) {
        this.dashboardInteractor = dashboardInteractor;
        this.examinerRepository = examinerRepository;
    }

    @GetMapping("/api/claims")
    public List<List<Object>> getAllSortedClaims(@RequestParam String username) {
        Optional<List<Claim>> claims = dashboardRepository.findClaimsByExaminer();
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