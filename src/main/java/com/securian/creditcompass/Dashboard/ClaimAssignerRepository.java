package com.securian.creditcompass.Dashboard;

import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClaimAssignerRepository extends JpaRepository<ClaimsExaminer, Integer> {}
