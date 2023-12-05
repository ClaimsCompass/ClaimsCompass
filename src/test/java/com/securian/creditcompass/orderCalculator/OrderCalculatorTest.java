package com.securian.creditcompass.orderCalculator;

import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.orderCalculator.OrderCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

class OrderCalculatorTest {
    private OrderCalculator orderCalculator;

    @BeforeEach
    void setup(){
        List<Claim> claims = createFakeClaims();
        orderCalculator = new OrderCalculator(claims);
        List<Claim> orderedClaims = orderFakeClaims(claims);
        testOrder(orderedClaims);
    }

    //Creating fake claims for testing
    List<Claim> createFakeClaims(){
        List<Claim> claims = new ArrayList<>();
        for (int i = 0; i <= 5; i++){
            Claim claim = new Claim(i, "life", "Life",
                    (float) 1000 + 1000 * i, 0, 0);
            claims.add(claim);
        }
        for (int i = 0; i <= 2; i++){
            Claim claim = new Claim(i, "life", "Illness",
                    (float) 1000 + 1000 * i, 0, 0);
            claims.add(claim);
        }
        Claim claim = new Claim(8, "illness",
                "CompletedDocuments:N Illness useless text should be ignored", 131141.4F,
                0, 0);
        claims.add(claim);
        return claims;
    }

    //Calculating the scores for the fake claims, as well as manually changing the urgency score for the others
    //which has to be done since we can not and should not ever modify the date a claim was created.
    List<Claim> orderFakeClaims(List<Claim> claims){
        claims.get(claims.size() - 1).setUrgencyScore(40);
        claims.get(claims.size() - 6).setUrgencyScore(50);
        orderCalculator.calculateScores(claims);
        List<Claim> orderedClaims = orderCalculator.orderClaims(claims);
        return orderedClaims;
    }

    @Test
    void testOrder(List<Claim> claims) {
        for (int i = 0; i < claims.size()-2; i++){
            //Print statements go here for a visualization
            System.out.println(claims.get(i).getTotalScore());
            System.out.println(claims.get(i).getUrgencyScore());
            System.out.println(claims.get(i).getComplexityScore());
            System.out.println("Order: " + i);
            System.out.println("--------");
            //Check if the claims are ordered by their scores
            assert (claims.get(i).getTotalScore() >= claims.get(i+1).getTotalScore());
            //Check if the urgency and complexity scores are weighted correctly
            assert (claims.get(i).getTotalScore() - claims.get(i).getUrgencyScore() ==
                    claims.get(i).getComplexityScore() * 6);
        }
    }
}