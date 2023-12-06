package com.securian.creditcompass.useCases.dashboard;

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
            claimAttributes.add(claim.getClaimAmount());
            claimAttributes.add(claim.getCreationDateTime());
            claimAttributes.add(claim.getClaimType());
            double urgency = claim.getUrgencyScore();
            //convert urgency score to hours
            double hours = Math.log(urgency + 1) / (0.193494007 * Math.log(2));
            //After a day and a half since claim was filed
            if (hours >= 32) {
                claimAttributes.add("High");
            }
            //After 18 hours since claim was first filed
            else if (hours >= 18) {
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
