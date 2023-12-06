package com.securian.creditcompass.entities;
import com.securian.creditcompass.ClaimState.AssignedClaimState;
import com.securian.creditcompass.ClaimState.ClaimStateChangeListener;
import com.securian.creditcompass.ClaimState.ClaimState;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
    private Integer complexityScore; // the two scores will need to be added after, can not be initialized

    @Getter
    @Column(name = "urgencyScore")
    private Integer urgencyScore; // a date perhaps?

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


    // TODO We may need read and write objects for ClaimState too, if we want to save
    //  it to the database?

    public Claim() {

    }

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
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

    public void setClaimExaminer(ClaimsExaminer examiner) {
        this.examiner = examiner.getUsername();
    }

    public void setExaminerByUsername(String examiner) {
        this.examiner = examiner;
    }

}



