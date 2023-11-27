package com.securian.creditcompass.dataAccess;

import com.securian.creditcompass.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    List<Claim> findClaimsByExaminer(String examiner);
    List<Claim> findAll();

}
