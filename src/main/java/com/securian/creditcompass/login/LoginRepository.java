package com.securian.creditcompass.login;

import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<ClaimsExaminer<T>, Long> {
    Optional<ClaimsExaminer<T>> findByFirstName(String firstName);
    Optional<ClaimsExaminer<T>> findByUsername(String username);
    Boolean existsByFirstName(String firstName);
    Boolean existsByUsername(String username);
}
