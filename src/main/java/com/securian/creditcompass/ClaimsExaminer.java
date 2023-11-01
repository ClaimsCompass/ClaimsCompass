package com.securian.creditcompass;
import jakarta.persistence.*;


@Entity
@Table(name = "claimsExaminer")
public class ClaimsExaminer {

    private String username;
    private String password;


    public ClaimsExaminer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

}