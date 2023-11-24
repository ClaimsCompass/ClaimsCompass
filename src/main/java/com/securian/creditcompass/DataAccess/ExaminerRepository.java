package com.securian.creditcompass.DataAccess;

import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ExaminerRepository extends JpaRepository<ClaimsExaminer, Long> {
    Optional<ClaimsExaminer> findByFirstName(String firstName);
    Optional<ClaimsExaminer> findByUsername(String username);
    Boolean existsByFirstName(String firstName);
    Boolean existsByUsername(String username);
}
