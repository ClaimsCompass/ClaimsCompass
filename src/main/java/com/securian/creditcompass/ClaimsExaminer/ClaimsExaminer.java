package com.securian.creditcompass.ClaimsExaminer;
import jakarta.persistence.*;


@Entity
@Table(name = "claimsExaminer")
class ClaimsExaminer {

    private final String username;
    private final String password;
    private final String firstName;

    @Id
    private Long id;

    public ClaimsExaminer() {
        this.username = null;
        this.password = null;
        this.firstName = null;
    }

    public ClaimsExaminer(String username, String password, String firstName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}