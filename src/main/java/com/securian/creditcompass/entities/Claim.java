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
        /*
        @param id: the id of the claim
        @param claimType: the type of claim
        @param claimDetails: the details of the claim
        @param claimAmt: the amount of the claim
        @param complexityScore: the complexity score of the claim
        @param urgencyScore: the urgency score of the claim
        */
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
        /*
        @return: the id of the claim
        */
        return this.id;
    }

    public String getClaimType() {
        /*
        @return: the type of the claim
        */
        return this.claimType;
    }

    public String getClaimDetails() {
        /*
        @return: the details of the claim
        */
        return this.claimDetails;
    }

    public Float getClaimAmount() {
        /*
        @return: the amount of the claim
        */
        return this.claimAmt; }

    public Integer getComplexityScore() {
        /*
        @return: the complexity score of the claim
         */
        return this.complexityScore;
    }

    public Integer getUrgencyScore() {
        /*
        @return: the urgency score of the claim
         */
        return this.urgencyScore;
    }

    public double getTotalScore(){
        /*
        @return: the total score of the claim
         */
        return this.totalScore;
    }

    public void setComplexityScore(Integer score){
        /*
        @param score: the complexity score of the claim
        */
        this.complexityScore = score;
    }

    public void setUrgencyScore(Integer score){
        /*
        @param score: the urgency score of the claim
         */
        this.urgencyScore = score;
    }

    public void setTotalScore(Integer score){
        /*
        @param score: the total score of the claim
         */
        this.totalScore = score;
    }

    public void setClaimExaminer(ClaimsExaminer examiner) {
        /*
        @param examiner: the examiner assigned to the claim
         */
        this.examiner = examiner.getUsername();
    }

    public boolean isProcessed(){
        /*
        @return: whether the claim has been processed
         */
        return this.processed;
    }

    public boolean processClaim(){
        /*
        @return: whether the claim has been processed
         */
        return this.processed = true;
    }

    public void setExaminerByUsername(String examiner) {
        /*
        @param examiner: the username of the examiner assigned to the claim
         */
        this.examiner = examiner;
    }

}



