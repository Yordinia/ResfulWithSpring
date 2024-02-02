package com.ResfulWithSpring.repositories;

import com.ResfulWithSpring.models.Flow;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlowRepository extends JpaRepository<Flow, Long> {
}
