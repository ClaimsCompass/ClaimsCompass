package com.securian.creditcompass.Dashboard;

import com.securian.creditcompass.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DashboardRepository extends JpaRepository<Claim, Integer> {
    Optional<List<Claim>> findClaimsByExaminer();
}
