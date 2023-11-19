package com.securian.creditcompass;
import com.securian.creditcompass.Claimant.Claimant;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "claimType")
    private String claimType;

    @Column(name = "claimDetails")
    private String claimDetails;

    @Column(name = "claimAmt")
    private Float claimAmt;

    @Column(name = "complexityScore")
    private Integer complexityScore; // the two scores will need to be added after, can not be initialized

    @Column(name = "urgencyScore")
    private Integer urgencyScore; // a date perhaps?

    @Column(name = "totalScore")
    private Double totalScore;

    @Column(name = "creationDateTime")
    private LocalDateTime creationDateTime;

    @Column(name = "processed")
    private Boolean processed;

    private ClaimState currentState;


    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    public Claim() {}

//    public Claim(String claimType, String claimDetails, Float claimAmt, Claimant claimant) {
//        this.claimType = claimType;
//        this.claimDetails = claimDetails;
//        this.claimAmt = claimAmt;
//        this.creationDateTime = LocalDateTime.now();
//        this.processed = false;
//        this.urgencyScore = 0;
//    }

    public Integer getId() {
        return this.id;
    }

    public String getClaimType() {
        return this.claimType;
    }

    public String getClaimDetails() {return this.claimDetails;}

    public Float getClaimAmt() { return this.claimAmt; }

    public Integer getComplexityScore() {return this.complexityScore;}

    public Integer getUrgencyScore() {return this.urgencyScore;}

    public void setComplexityScore(Integer score){this.complexityScore = score;}

    public void setUrgencyScore(Integer score){this.urgencyScore = score;}

    public LocalDateTime getCreationDateTime(){return this.creationDateTime;}

    public void calculateTotalScore(){
        this.totalScore = this.complexityScore * 0.1 + this.urgencyScore;
    }

    public double getTotalScore(){return this.totalScore;}

    public boolean isProcessed(){return this.processed;}

    public boolean processClaim(){return this.processed = true;}
}