package com.securian.creditcompass.dashboard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class DashboardController {
    private final DashboardInputBoundary dashboardInteractor;

    public DashboardController(DashboardInputBoundary dashboardInteractor) {
        this.dashboardInteractor = dashboardInteractor;
    }

    @PostMapping("/api/claims")
    //TODO: Remove List<List<Object>> - it's bad practice.
    public List<List<Object>> execute(@RequestParam String username) {
        DashboardInputData dashboardInputData = new DashboardInputData(username);
        return dashboardInteractor.execute(dashboardInputData);

    }
}
