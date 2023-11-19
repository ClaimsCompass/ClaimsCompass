package com.securian.creditcompass.OrderCalculator;

import com.securian.creditcompass.entities.Claim;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import java.time.LocalDateTime;
import java.time.Duration;

public class OrderCalculator implements Iterable<Claim>{
    private List<Claim> claims;
    private List<Claim> orderedClaims;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    public OrderCalculator() {}

    @Override
    public Iterator<Claim> iterator() {
        return new Iter();
    }
    private class Iter implements Iterator<Claim> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < claims.size();
        }

        @Override
        public Claim next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return claims.get(currentIndex++);
        }
    }
    public OrderCalculator(List<Claim> claims) {

        this.claims = claims;
        calculateScores(this.claims);
        this.orderedClaims = orderClaims(this.claims);
    }

    public List<Claim> getOrderedClaims(){return this.orderedClaims;}

    private void calculateScores(List<Claim> claims){
        for (Claim claim : claims){
            Duration duration = Duration.between(claim.getCreationDateTime(), LocalDateTime.now());
            int intervals = (int) Math.floorDiv(duration.toHours(), 1);
            int urgencyScore = claim.getUrgencyScore();
            int newUrgencyScore = 0;
            if (urgencyScore <= intervals){
                newUrgencyScore = (int) Math.pow(2, (0.193494007 * intervals)) - 1;
            }
            if (newUrgencyScore > urgencyScore){
                claim.setUrgencyScore(newUrgencyScore);
            }
            calculateTotalScore(claim);
        }
    }

    private void calculateTotalScore(Claim claim){
        int urgencyScore = claim.getUrgencyScore();
        int complexityScore = claim.getComplexityScore();
        claim.setTotalScore(urgencyScore + (complexityScore * 6));
    }

    private List<Claim> orderClaims(List<Claim> claims){
        claims.sort(Comparator.comparingDouble(Claim::getTotalScore).reversed());
        return claims;
    }
}
