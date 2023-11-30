package com.securian.creditcompass.dataAccess;

import com.securian.creditcompass.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    Optional<List<Claim>> findByExaminer(String examiner);
    List<Claim> findAll();

    List<Claim> findClaimsByExaminer(String examiner);
}
