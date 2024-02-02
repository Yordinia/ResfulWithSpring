package com.ResfulWithSpring.repositories;

import com.ResfulWithSpring.models.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
