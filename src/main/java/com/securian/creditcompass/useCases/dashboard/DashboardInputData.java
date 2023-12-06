package com.securian.creditcompass.useCases.dashboard;

import lombok.Getter;

public class DashboardInputData {

    @Getter
    private String username;

    @Getter
    private Boolean displayProcessed;

    public DashboardInputData(String username, Boolean displayProcessed) {
        this.username = username;
        this.displayProcessed = displayProcessed;
    }


}
