package com.securian.creditcompass.useCases.claimPage;

import com.securian.creditcompass.orderCalculator.OrderCalculator;
import com.securian.creditcompass.dataAccess.ClaimRepository;
import com.securian.creditcompass.entities.Claim;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClaimPageInteractor implements ClaimPageInputBoundary {
    private final ClaimRepository claimRepository;
    private final OrderCalculator orderCalculator;

    public ClaimPageInteractor(ClaimRepository claimRepository, OrderCalculator orderCalculator) {
        this.claimRepository = claimRepository;
        this.orderCalculator = orderCalculator;
    }

    @Override
    public void execute_post(ClaimPageInputData claimPageInputData) {
        Optional<Claim> maybeClaim = claimRepository.findById(claimPageInputData.claimId);

        if (maybeClaim.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ClaimID not found.");
        }

        Claim claim = maybeClaim.get();
        maybeClaim.get().processClaim();
        claimRepository.save(claim);
    }

    public Claim execute_get(ClaimPageInputData claimPageInputData){
        Optional<Claim> maybeClaim = claimRepository.findById(claimPageInputData.claimId);

        if (maybeClaim.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ClaimID not found.");
        }
        return maybeClaim.get();
    }


}
