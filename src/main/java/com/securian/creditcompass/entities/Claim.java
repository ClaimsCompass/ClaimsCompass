package com.securian.creditcompass.entities;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Entity
@Table(name = "claims")
public class Claim {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Column(name = "claimType")
    private String claimType;

    @Getter
    @Column(name = "claimDetails")
    private String claimDetails;

    @Getter
    @Column(name = "claimAmt")
    private Float claimAmt;

    @Getter
    @Column(name = "complexityScore")
    private Integer complexityScore;

    @Getter
    @Column(name = "urgencyScore")
    private Integer urgencyScore;

    @Column(name = "totalScore")
    private Integer totalScore;

    @Getter
    @Column(name = "creationDateTime")
    private LocalDateTime creationDateTime;

    @Column(name = "processed")
    private Boolean processed;

    @Getter
    @Column(name = "examiner")
    private String examiner;

    public Claim() {
        // Hibernate expects entities to have a no-arg constructor,
        // though it does not necessarily have to be public.
    }

    public Claim(Integer id, String claimType, String claimDetails, Float claimAmt, Integer complexityScore, Integer urgencyScore) {
        this.id = id;
        this.claimType = claimType;
        this.claimDetails = claimDetails;
        this.claimAmt = claimAmt;
        this.complexityScore = complexityScore;
        this.urgencyScore = urgencyScore;
        this.creationDateTime = LocalDateTime.now();
        this.processed = false;
    }

    public Integer getId() {
        return this.id;
    }

    public String getClaimType() {
        return this.claimType;
    }

    public String getClaimDetails() {return this.claimDetails;}

    public Float getClaimAmount() { return this.claimAmt; }

    public Integer getComplexityScore() {return this.complexityScore;}

    public Integer getUrgencyScore() {return this.urgencyScore;}

    public double getTotalScore(){return this.totalScore;}

    public void setComplexityScore(Integer score){this.complexityScore = score;}

    public void setUrgencyScore(Integer score){this.urgencyScore = score;}

    public void setTotalScore(Integer score){this.totalScore = score;}

    public void setClaimExaminer(ClaimsExaminer examiner) {
        this.examiner = examiner.getUsername();
    }

    public boolean isProcessed(){return this.processed;}

    public boolean processClaim(){return this.processed = true;}

    public void setExaminerByUsername(String examiner) {
        this.examiner = examiner;
    }

}



