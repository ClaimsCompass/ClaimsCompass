package com.securian.creditcompass.Claimant;
import jakarta.persistence.*;


@Entity
@Table(name = "claimants")
public class Claimant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    private String addldesc;

    public Claimant() {}

    public Claimant(String Name, String addldesc) {
        this.name = Name;
        this.addldesc = addldesc;
    }

    public String getClaimantName() {
        return this.name;
    }

    public Integer getUserID() {return this.id; }

    public String getAddlDesc() {return this.addldesc;}

}
