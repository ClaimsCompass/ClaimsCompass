package com.securian.creditcompass.ClaimState;

import com.securian.creditcompass.ClaimState.ClaimState;
import com.securian.creditcompass.entities.Claim;

public interface ClaimStateChangeListener {
    void stateChanged(Claim claim, ClaimState newState);
}