package com.restwithspring.repositories;

import com.restwithspring.models.EchoStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchoStepRepository extends JpaRepository<EchoStep, Long> {
}
