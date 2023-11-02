package com.securian.creditcompass.PolicyHolder;
import jakarta.persistence.*;


@Entity
@Table(name = "policyholders")
public class PolicyHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    private String addldesc;

    public PolicyHolder() {}

    public PolicyHolder(String Name, String addldesc) {
        this.name = Name;
        this.addldesc = addldesc;
    }

    public String getPolicyHolderName() {
        return this.name;
    }

    public Integer getPolicyHolderID() {return this.id; }

    public String getAddlDesc() {return this.addldesc;}

}
