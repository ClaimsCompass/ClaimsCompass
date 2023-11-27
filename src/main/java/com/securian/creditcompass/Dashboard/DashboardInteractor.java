package com.securian.creditcompass.dashboard;

import com.securian.creditcompass.OrderCalculator.OrderCalculator;
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
        List<Claim> claimsList = claimRepository.findByExaminer(dashboardInputData.getUsername()).
                orElse(new ArrayList<>());

        //TODO: Do we need to change OrderCalculator to a helper method? Furthermore, OrderCalculator
        // does not need to be an Iterator.


        // Calculate the complexity and urgency score for each claim
        orderCalculator.calculateScores(claimsList);

        // Order the claims according to highest urgency and complexity
        List<Claim> orderedClaims = orderCalculator.orderClaims(claimsList);

        DashboardOutputData dashboardOutputData = new DashboardOutputData(orderedClaims);

        // TODO: Is the following correct? Controller -> InputData -> Interactor -> OutputData
        //  Ideally, you would have it end at Presenter, but we do not have a presenter.
        return dashboardOutputData.execute();
    }
}
