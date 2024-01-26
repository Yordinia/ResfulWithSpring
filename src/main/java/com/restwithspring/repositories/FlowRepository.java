package com.restwithspring.repositories;

import com.restwithspring.models.Flow;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlowRepository extends JpaRepository<Flow, Long> {
}
