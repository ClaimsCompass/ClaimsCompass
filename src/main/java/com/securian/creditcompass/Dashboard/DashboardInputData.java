package com.securian.creditcompass.dashboard;

import lombok.Getter;

@Getter
public class DashboardInputData {
    final private String username;

    public DashboardInputData(String username) {
        this.username = username;
    }

}
