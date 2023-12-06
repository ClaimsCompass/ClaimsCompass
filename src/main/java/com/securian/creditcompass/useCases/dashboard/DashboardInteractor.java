package com.securian.creditcompass.useCases.dashboard;

import com.securian.creditcompass.orderCalculator.OrderCalculator;
import com.securian.creditcompass.dataAccess.ClaimRepository;
import com.securian.creditcompass.entities.Claim;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardInteractor implements DashboardInputBoundary {
    private final ClaimRepository claimRepository;
    private final OrderCalculator orderCalculator;

    public DashboardInteractor(ClaimRepository claimRepository, OrderCalculator orderCalculator) {
        /*
        @param claimRepository: the repository used to access the claims
        @param orderCalculator: the calculator used to calculate the order of the claims
         */
        this.claimRepository = claimRepository;
        this.orderCalculator = orderCalculator;
    }

    @Override
    public List<List<Object>> execute(DashboardInputData dashboardInputData) {
        /*
        @param dashboardInputData: the input data for the dashboard
        @return: the dashboard data for the given user
         */

        // Find all the claims associated with the given examiner. Notice that the examiner might not
        // have any claims associated with them.
        System.out.println(dashboardInputData.getUsername());
        List<Claim> claimsList = claimRepository.findByExaminer(dashboardInputData.getUsername()).
                orElse(new ArrayList<>());

        System.out.println(claimsList.size());

        // Calculate the complexity and urgency score for each claim
        orderCalculator.calculateScores(claimsList);

        // Order the claims according to highest urgency and complexity
        List<Claim> orderedClaims = orderCalculator.orderClaims(claimsList);
        ArrayList<Claim> filteredClaims = new ArrayList<>();
        // Get rid of claims that have been processed
        if (dashboardInputData.getDisplayProcessed()) {
            for (Claim claim : orderedClaims) {
                if (claim.isProcessed()) {
                    filteredClaims.add(claim);
                }
            }
        } else {
            for (Claim claim : orderedClaims) {
                if (!claim.isProcessed()) {
                    filteredClaims.add(claim);
                }
            }
        }

        //Update the database with the new scores
        claimRepository.saveAll(orderedClaims);

        DashboardOutputData dashboardOutputData = new DashboardOutputData(filteredClaims);

        return dashboardOutputData.execute();
    }
}
