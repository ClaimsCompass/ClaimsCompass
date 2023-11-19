package com.securian.creditcompass;
import jakarta.persistence.*;


@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String claimType;

    private String claimDetails;

    private Float claimAmt;


    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    public Claim() {}

    public Claim(String claimType, String claimDetails, Float claimAmt) {
        this.claimType = claimType;
        this.claimDetails = claimDetails;
        this.claimAmt = claimAmt;
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
}