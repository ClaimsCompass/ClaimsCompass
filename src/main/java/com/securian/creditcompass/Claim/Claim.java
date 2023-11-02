package com.securian.creditcompass.Claim;
import com.securian.creditcompass.Claimant.Claimant;
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

    private Claimant claimant;


    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    public Claim() {}

    public Claim(String claimType, String claimDetails, Float claimAmt, Claimant claimant) {
        this.claimType = claimType;
        this.claimDetails = claimDetails;
        this.claimAmt = claimAmt;
        this.claimant = claimant;
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
