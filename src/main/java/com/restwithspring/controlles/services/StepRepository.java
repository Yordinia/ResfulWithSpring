package com.restwithspring.controlles.services;

import com.restwithspring.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
