package com.securian.creditcompass.dataAccess;

import com.securian.creditcompass.entities.ClaimsExaminer;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExaminerRepository extends JpaRepository<ClaimsExaminer, Long> {
    Optional<ClaimsExaminer> findByUsername(String username);

    @NotNull
    List<ClaimsExaminer> findAll();
}
