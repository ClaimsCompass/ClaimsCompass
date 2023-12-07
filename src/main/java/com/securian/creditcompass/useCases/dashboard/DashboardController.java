package com.securian.creditcompass.useCases.dashboard;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class DashboardController {
    private final DashboardInteractor dashboardInteractor;

    public DashboardController(DashboardInteractor dashboardInteractor) {
        /*
        @param dashboardInteractor: the interactor used to get the dashboard data
         */
        this.dashboardInteractor = dashboardInteractor;
    }

    @PostMapping("/api/claims")
    public List<List<Object>> execute(@RequestParam String username, @RequestParam Boolean isProcessed) {
        /*
        @param username: the username of the user to get the dashboard data for
        @param isProcessed: whether to get the processed or unprocessed claims
        @return: the dashboard data for the given user
         */
        DashboardInputData dashboardInputData = new DashboardInputData(username, isProcessed);
        return dashboardInteractor.execute(dashboardInputData);

    }
}
