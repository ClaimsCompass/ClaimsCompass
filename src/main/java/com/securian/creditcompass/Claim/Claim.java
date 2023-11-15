package com.securian.creditcompass.Claim;
import com.securian.creditcompass.Claimant.Claimant;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String claimType;

    private String claimDetails;

    private Float claimAmt;

    private Integer complexityScore; // the two scores will need to be added after, can not be initialized

    private Integer urgencyScore; // a date perhaps?

    private Double totalScore;

    private LocalDateTime creationDateTime;


    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    public Claim() {}

    public Claim(String claimType, String claimDetails, Float claimAmt, Claimant claimant) {
        this.claimType = claimType;
        this.claimDetails = claimDetails;
        this.claimAmt = claimAmt;
        this.creationDateTime = LocalDateTime.now();
    }

    public Integer getId() {
        return this.id;
    }

    public String getClaimType() {
        return this.claimType;
    }

    public String getClaimDetails() {
        return this.claimDetails;
    }

    public Float getClaimAmt() { return this.claimAmt; }

    public Integer getComplexityScore() {return this.complexityScore;}

    public Integer getUrgencyScore() {return this.urgencyScore;}

    public void setComplexityScore(Integer score){this.complexityScore = score;}

    public void setUrgencyScore(Integer score){this.urgencyScore = score;}

    public LocalDateTime getCreationDateTime(){return this.creationDateTime;}

    public void calculateTotalScore(){
        this.totalScore = this.complexityScore * 0.1 + this.urgencyScore;
    }

}
