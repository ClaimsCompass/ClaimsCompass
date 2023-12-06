package com.securian.creditcompass.orderCalculator;

import com.securian.creditcompass.entities.Claim;

import java.util.HashMap;

public class IterativeComplexityAlgorithm implements ComplexityAlgorithm{
    @Override
    public int calculateComplexity(Claim claim) {
        /*
        @param claim: the claim to calculate the complexity of
        @return: the complexity of the claim
        */

        HashMap<String, Integer> keywordsMap = new HashMap<String, Integer>();
        keywordsMap.put("Life",1);
        keywordsMap.put("Unemployment",2);
        keywordsMap.put("Illness",3);
        keywordsMap.put("Disability",3);
        keywordsMap.put("CompletedDocuments:N",6);
        keywordsMap.put("AccurateDocuments:N",5);

        String claimDetails = claim.getClaimDetails();
        String[] details = claimDetails.split(" ");
        int complexityScore = 0;
        for (int i = 0; i < details.length; i++){
            String header = details[i];
            if (keywordsMap.containsKey(header)){
                complexityScore += keywordsMap.get(header);
            }
        }

        claim.setComplexityScore(complexityScore);
        return complexityScore;
    }
}
