package entities;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;



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

    public ClaimsExaminer(String username, String password, String firstName, Long id) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.id = id;
    }

}
