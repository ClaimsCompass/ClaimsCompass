package entities;
import jakarta.persistence.*;


@Entity
@Table(name = "claimsExaminer")
public class ClaimsExaminer {

    private String username;
    private String password;
    private String firstName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ClaimsExaminer(String username, String password, String firstName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
    }

    public ClaimsExaminer() {

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
    public Long getId() {return this.id;}

}
