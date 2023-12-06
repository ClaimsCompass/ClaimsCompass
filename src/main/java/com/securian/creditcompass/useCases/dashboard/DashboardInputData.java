package com.securian.creditcompass.useCases.dashboard;

import lombok.Getter;

public class DashboardInputData {

    @Getter
    private String username;

    @Getter
    private Boolean displayProcessed;

    public DashboardInputData(String username, Boolean displayProcessed) {
        /*
        @param username: the username of the user to get the dashboard data for
        @param displayProcessed: whether to get the processed or unprocessed claims
         */
        this.username = username;
        this.displayProcessed = displayProcessed;
    }


}
