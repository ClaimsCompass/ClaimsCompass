package com.securian.creditcompass.DataAccess;

import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExaminerRepository extends JpaRepository<ClaimsExaminer, Long> {
    Optional<ClaimsExaminer> findByFirstName(String firstName);
    Optional<ClaimsExaminer> findByUsername(String username);
    Boolean existsByFirstName(String firstName);
    Boolean existsByUsername(String username);
}
