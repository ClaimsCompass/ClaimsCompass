package com.securian.creditcompass.useCases.dashboard;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


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
    public List<List<Object>> execute(@RequestBody Map<String, String> body) {
        /*
        @param username: the username of the user to get the dashboard data for
        @param isProcessed: whether to get the processed or unprocessed claims
        @return: the dashboard data for the given user
         */
        String username = body.get("username");
        Boolean isProcessed = Boolean.valueOf(body.get("isProcessed"));
        DashboardInputData dashboardInputData = new DashboardInputData(username, isProcessed);
        return dashboardInteractor.execute(dashboardInputData);

    }
}
