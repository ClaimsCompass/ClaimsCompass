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
                // After approximately 100 hours, the urgency score will be 1000000
                // which acts as a hard stop to the urgency score as to prevent
                // integer overflow since it is dealing with an exponential function
            if (newUrgencyScore > 1000000){
                claim.setUrgencyScore(1000000);
            }
            else{
                claim.setUrgencyScore(newUrgencyScore);
            }

            ComplexityAlgorithm iterativeAlgorithm = new IterativeComplexityAlgorithm();
            ComplexityCalculator complexityCalculator = new ComplexityCalculator(iterativeAlgorithm);

            int complexityScore = complexityCalculator.calculateComplexity(claim);

            claim.setComplexityScore(complexityScore);
            calculateTotalScore(claim);
        }
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
