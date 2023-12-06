package com.securian.creditcompass.useCases.dashboard;

import java.util.List;

public interface DashboardInputBoundary {
    List<List<Object>> execute(DashboardInputData dashboardInputData);
}
