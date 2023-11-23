package com.securian.creditcompass.entities;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "claimsExaminer")
public class ClaimsExaminer<T> {

    private String username;
    private String password;
    private String firstName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    transient List<Claim> claims;

    public ClaimsExaminer(String username, String password, String firstName, Long id) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.id = id;
    }

    private int getClaimCount() {
        // return the number of claims assigned to this examiner
        List<Claim> claims = this.claims;
        if (claims == null) {
            return 0;
        }
        else {
            return claims.size();
        }
    }

    public int getExaminerScore() {
        // return the total score of all claims assigned to this examiner
        List<Claim> claims = this.claims;
        if (claims == null) {
            return 0;
        }
        else {
            int totalScore = 0;
            for (Claim claim : claims) {
                totalScore += (int) claim.getTotalScore();
            }
            return totalScore;
        }
    }

    // From a list of claims examiners, return the one with the minimum examiner score
    private ClaimsExaminer<?> getExaminerWithMinScore(List<ClaimsExaminer<?>> examiners) {
        ClaimsExaminer<?> minExaminer = examiners.get(0);
        for (ClaimsExaminer<?> examiner : examiners) {
            if (examiner.getExaminerScore() < minExaminer.getExaminerScore()) {
                minExaminer = examiner;
            }
        }
        return minExaminer;
    }
}
