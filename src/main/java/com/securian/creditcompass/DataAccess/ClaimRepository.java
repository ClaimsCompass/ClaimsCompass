package com.securian.creditcompass.DataAccess;

import com.securian.creditcompass.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClaimRepository extends JpaRepository<Claim, Long> {

    List<Claim> findClaimsByExaminer(String examiner);

}
