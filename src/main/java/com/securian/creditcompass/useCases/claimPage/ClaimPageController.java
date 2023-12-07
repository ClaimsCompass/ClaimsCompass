package com.securian.creditcompass.useCases.claimPage;

import com.securian.creditcompass.entities.Claim;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ClaimPageController {
    private final ClaimPageInputBoundary claimPageInteractor;

    public ClaimPageController(ClaimPageInputBoundary claimPageInteractor) {
        /*
        @param claimPageInteractor: the interactor used to get a single claim by id
         */
        this.claimPageInteractor = claimPageInteractor;
    }

    @PostMapping("/api/getClaimById") // API endpoint to get a single claim by id
    public Claim getClaimById(@RequestBody Map<String, String> body) {
        /*
        @param id: the id of the claim to get
        @return: the claim with the given id
        */
        Long id = Long.valueOf(body.get("claimId"));
        var inputData = new ClaimPageInputData(id, false);
        return claimPageInteractor.execute_get(inputData);
    }

    @PostMapping("/api/updateProcessedClaim") // POST mapping to indicate that a claim has been processed
    public void updateProcessedClaim(@RequestBody Map<String, String> body) {
        /*
        @param id: the id of the claim to update
         */
        Long id = Long.valueOf(body.get("claimId"));
        var inputData = new ClaimPageInputData(id, true);
        claimPageInteractor.execute_post(inputData);
    }
}