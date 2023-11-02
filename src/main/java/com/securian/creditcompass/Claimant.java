package com.securian.creditcompass;
import jakarta.persistence.*;


@Entity
@Table(name = "claimants")
public class Claimant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Claim claim;

    private String name;

    public Claimant() {}

    public Claimant(Claim claim, String Name) {
        this.claim = claim;
        this.name = Name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUserClaim() {
        return this.claim;
    }

    public String getClaimDetails() {
        return this.claimDetails;
    }

    public Float getClaimAmt() { return this.claimAmt; }
}
