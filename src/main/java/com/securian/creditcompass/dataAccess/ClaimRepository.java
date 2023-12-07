package com.securian.creditcompass.dataAccess;

import com.securian.creditcompass.entities.Claim;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    //@Query("select c from claim where claim.examiner=?1")
    Optional<List<Claim>> findByExaminer(String examiner);

    @NotNull
    List<Claim> findAll();

    List<Claim> findClaimsByExaminer(String examiner);
}
