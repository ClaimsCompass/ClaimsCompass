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
        this.claimRepository = claimRepository;
        this.orderCalculator = orderCalculator;
    }

    @Override
    public List<List<Object>> execute(DashboardInputData dashboardInputData) {

        // Find all the claims associated with the given examiner. Notice that the examiner might not
        // have any claims associated with them.
        System.out.println(dashboardInputData.getUsername());
        List<Claim> claimsList = claimRepository.findByExaminer(dashboardInputData.getUsername()).
                orElse(new ArrayList<>());
        //List<Claim> claimsList = claimRepository.findAll();

        //TODO: Do we need to change orderCalculator to a helper method? Furthermore, OrderCalculator
        // does not need to be an Iterator.
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

        DashboardOutputData dashboardOutputData = new DashboardOutputData(filteredClaims);

        // TODO: Is the following correct? Controller -> InputData -> Interactor -> OutputData
        //  Ideally, you would have it end at Presenter, but we do not have a presenter.
        return dashboardOutputData.execute();
    }

//    @GetMapping("/api/processedClaims") // API endpoint to get all claims
//    public List<List<Object>> getAllSortedProcessedClaims() {
//        List<Claim> claims = claimRepository.findAll();
//        OrderCalculator scoredClaims = new OrderCalculator(claims);
//        List<Claim> sortedClaims = scoredClaims.getOrderedClaims();
//
//        ArrayList<Claim> filteredClaims = new ArrayList<Claim>();
//        for (int i = 0; i < sortedClaims.size(); i++) {
//            if (sortedClaims.get(i).isProcessed()) {
//                filteredClaims.add(sortedClaims.get(i));
//            }
//        }
//        return renderDashboardService.findAttributes(filteredClaims);
//    }
}
