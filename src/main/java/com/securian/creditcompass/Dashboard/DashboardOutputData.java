package com.securian.creditcompass.dashboard;

import com.securian.creditcompass.entities.Claim;

import java.util.ArrayList;
import java.util.List;

public class DashboardOutputData {
    private final List<Claim> orderedClaims;

    public DashboardOutputData(List<Claim> orderedClaims){
        this.orderedClaims = orderedClaims;
    }

    public List<List<Object>> execute() {
        List<List<Object>> allClaimsAttributes = new ArrayList<>();


        for (Claim claim : orderedClaims) {
            // Iterate through each claim. Store information about each claim inside a list.
            List<Object> claimAttributes = new ArrayList<>();
            claimAttributes.add(claim.getId());
            claimAttributes.add(claim.getClaimAmt());
            claimAttributes.add(claim.getCreationDateTime());
            claimAttributes.add(claim.getClaimType());
            double urgency = claim.getUrgencyScore();
            if (urgency >= 6) {
                claimAttributes.add("High");
            }
            else if (urgency >= 3) {
                claimAttributes.add("Medium");
            }
            else {
                claimAttributes.add("Low");
            }
            double complexity = claim.getComplexityScore();
            if (complexity >= 7) {
                claimAttributes.add("High");
            }
            else if (complexity >= 4) {
                claimAttributes.add("Medium");
            }
            else {
                claimAttributes.add("Low");
            }
            allClaimsAttributes.add(claimAttributes);
        }
        // Return a list of claims that each have a list of attributes.
        return allClaimsAttributes;
    }
}
