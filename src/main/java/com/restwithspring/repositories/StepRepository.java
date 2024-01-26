package com.restwithspring.repositories;

import com.restwithspring.models.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
