package com.securian.creditcompass.entities;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "claimsExaminer")
public class ClaimsExaminer {

    private String username;
    private String password;
    private String firstName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    transient List<Claim> claims;

    public ClaimsExaminer(String username, String password, String firstName, Long id) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.id = id;
    }


}
