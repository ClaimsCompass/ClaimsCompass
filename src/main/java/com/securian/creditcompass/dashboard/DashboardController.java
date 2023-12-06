package com.securian.creditcompass.dashboard;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
public class DashboardController {
    private final DashboardInteractor dashboardInteractor;

    public DashboardController(DashboardInteractor dashboardInteractor) {
        this.dashboardInteractor = dashboardInteractor;
    }

    @PostMapping("/api/claims")
    //TODO: Remove List<List<Object>> - it's bad practice.
    public List<List<Object>> execute(@RequestBody Map<String, String> userData) {
        String username = userData.get("username");
        Boolean isProcessed = Boolean.valueOf(userData.get("username"));
        System.out.println("isProcessed: " + isProcessed);
        DashboardInputData dashboardInputData = new DashboardInputData(username, isProcessed);
        return dashboardInteractor.execute(dashboardInputData);

    }
}
