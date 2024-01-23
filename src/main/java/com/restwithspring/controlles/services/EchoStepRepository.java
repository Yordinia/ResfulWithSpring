package com.restwithspring.controlles.services;

import com.restwithspring.EchoStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchoStepRepository extends JpaRepository<EchoStep, Long> {
}
