package com.securian.creditcompass.Allocation;

import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<ClaimsExaminer, Integer> {}
