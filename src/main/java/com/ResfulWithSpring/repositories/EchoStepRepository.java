package com.ResfulWithSpring.repositories;

import com.ResfulWithSpring.models.EchoStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchoStepRepository extends JpaRepository<EchoStep, Long> {
}
