package com.securian.creditcompass.OrderCalculator;

import com.securian.creditcompass.Claim.Claim;
import com.securian.creditcompass.Claimant.Claimant;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    }

    private void calculateScores(List<Claim> claims){
        for (Claim claim : claims){
            int score = claim.getComplexityScore();
            Duration duration = Duration.between(claim.getCreationDateTime(), LocalDateTime.now());
            int interval = (int) Math.floorDiv(duration.toHours(), 6);
            int urgencyScore = claim.getUrgencyScore();
            int newUrgencyScore = 0;
            for (int i = urgencyScore; i > 0; i--){
                newUrgencyScore++;
            }
            if (newUrgencyScore > urgencyScore){
                claim.setUrgencyScore(newUrgencyScore);
            }
            claim.calculateTotalScore();
        }

    }
    private List<Claim> orderClaims(List<Claim> claims){

    }
}
