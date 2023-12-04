package com.securian.creditcompass.claimPage;

import com.securian.creditcompass.orderCalculator.OrderCalculator;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.dataAccess.ClaimRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ClaimPageController {
    private final ClaimPageInputBoundary claimPageInteractor;

    public ClaimPageController(ClaimPageInputBoundary claimPageInteractor) {
        this.claimPageInteractor = claimPageInteractor;
    }

    @GetMapping("/api/getClaimById") // API endpoint to get a single claim by id
    public Claim getClaimById(@RequestParam Long id) {
        var inputData = new ClaimPageInputData(id, true);
        return claimPageInteractor.execute_get(inputData);
    }

    @PostMapping("/api/updateProcessedClaim") // POST mapping to indicate that a claim has been processed
    public void updateProcessedClaim(@RequestParam Long id) {
        var inputData = new ClaimPageInputData(id, true);
        claimPageInteractor.execute_post(inputData);
    }
}