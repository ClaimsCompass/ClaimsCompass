package com.securian.creditcompass.Dashboard;

import com.securian.creditcompass.OrderCalculator.OrderCalculator;
import com.securian.creditcompass.dashboard.DashboardInputBoundary;
import com.securian.creditcompass.dashboard.DashboardInputData;
import com.securian.creditcompass.dataAccess.ClaimRepository;
import com.securian.creditcompass.entities.Claim;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardInteractor implements DashboardInputBoundary {
    private final ClaimRepository claimRepository;

    public DashboardInteractor(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Override
    public List<List<Object>> execute(DashboardInputData dashboardInputData) {

        // Find all the claims associated with the given examiner. Notice that the examiner might not
        // have any claims associated with them.
        Optional<List<Claim>> claimsList = claimRepository.findClaimsByExaminer(dashboardInputData.getUsername());

        //TODO: Do we need to change OrderCalculator to a helper method? Furthermore, OrderCalculator
        // does not need to be an Iterator.


        // If the examiner has claims:
        if (claimsList.isPresent()) {
            //
            OrderCalculator scoredClaims = new OrderCalculator(claims.get());
            List<Claim> sortedClaims = scoredClaims.getOrderedClaims();
            return renderDashboardService.findAttributes(sortedClaims);
        } else {
            return new ArrayList<>();
        }
    }
}
