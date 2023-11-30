package com.securian.creditcompass.orderCalculator;

import com.securian.creditcompass.entities.Claim;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import java.time.LocalDateTime;
import java.time.Duration;

@Service
public class OrderCalculator{
    private List<Claim> claims;
    private List<Claim> orderedClaims;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    public OrderCalculator(List<Claim> claims) {
        this.claims = claims;
    }

//    public List<Claim> getOrderedClaims(){return this.orderedClaims;}

    public void calculateScores(List<Claim> claims){
        HashMap<String, Integer> keywords = new HashMap<String, Integer>();
        fillKeywords(keywords);

        for (Claim claim : claims){
            Duration duration = Duration.between(claim.getCreationDateTime(), LocalDateTime.now());
            int intervals = (int) Math.floorDiv(duration.toHours(), 1);
            int urgencyScore = claim.getUrgencyScore();
            int newUrgencyScore = 0;

            if (urgencyScore <= intervals){
                // This is the function y=2^{(0.193494007x)}-1 which was generated so that
                // the urgency score will be equal to the complexity score at 24 hours
                // and rapidly increase exponentially following 24 hours
                newUrgencyScore = (int) Math.pow(2, (0.193494007 * intervals)) - 1;
            }
            if (newUrgencyScore > urgencyScore){
                claim.setUrgencyScore(newUrgencyScore);
            }

            //Complexity
            String claimDetails = claim.getClaimDetails();
            String[] details = claimDetails.split(" ");
            int complexityScore = 0;
            for (int i = 0; i < details.length; i++){
                String header = details[i];
                if (keywords.containsKey(header)){
                    complexityScore += keywords.get(header);
                }
            }

            claim.setComplexityScore(complexityScore);
            calculateTotalScore(claim);
        }
    }

    private void fillKeywords(HashMap<String, Integer> keywordsMap){
        keywordsMap.put("Life",1);
        keywordsMap.put("Unemployment",2);
        keywordsMap.put("Illness",3);
        keywordsMap.put("Disability",3);
        keywordsMap.put("CompletedDocuments:N",6);
        keywordsMap.put("AccurateDocuments:N",5);
    }


    private void calculateTotalScore(Claim claim){
        int urgencyScore = claim.getUrgencyScore();
        int complexityScore = claim.getComplexityScore();
        claim.setTotalScore(urgencyScore + (complexityScore * 6));
    }

    public List<Claim> orderClaims(List<Claim> claims){
        claims.sort(Comparator.comparingDouble(Claim::getTotalScore).reversed());
        return claims;
    }
}
