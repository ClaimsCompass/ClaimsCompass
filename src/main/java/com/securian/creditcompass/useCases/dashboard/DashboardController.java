package com.securian.creditcompass.useCases.dashboard;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class DashboardController {
    private final DashboardInteractor dashboardInteractor;

    public DashboardController(DashboardInteractor dashboardInteractor) {
        this.dashboardInteractor = dashboardInteractor;
    }

    @PostMapping("/api/claims")
    //TODO: Remove List<List<Object>> - it's bad practice.
    public List<List<Object>> execute(@RequestParam String username, @RequestParam Boolean isProcessed) {
        System.out.println("isProcessed: " + isProcessed);
        DashboardInputData dashboardInputData = new DashboardInputData(username, isProcessed);
        return dashboardInteractor.execute(dashboardInputData);

    }
}