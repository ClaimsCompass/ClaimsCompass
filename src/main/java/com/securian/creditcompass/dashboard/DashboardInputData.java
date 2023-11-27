package com.securian.creditcompass.dashboard;

import lombok.Getter;

public class DashboardInputData {

    @Getter
    private String username;

    public DashboardInputData(String username) {
        this.username = username;
    }


}
