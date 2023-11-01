package com.securian.creditcompass;
import jakarta.persistence.*;


@Entity
@Table(name = "claimsExaminer")
public class ClaimsExaminer {

    private String username;
    private String password;
    private String firstName;


    public ClaimsExaminer(String username, String password, String firstName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

}
