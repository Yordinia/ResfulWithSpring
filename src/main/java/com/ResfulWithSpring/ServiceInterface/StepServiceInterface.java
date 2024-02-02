package com.ResfulWithSpring.ServiceInterface;

import com.ResfulWithSpring.models.Step;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StepServiceInterface {
    List<Step> getAllSteps();
    ResponseEntity<Step> saveStep(Step step);
    ResponseEntity<Step> findStepById(Long id);
    ResponseEntity<Step> updateStep(Step step, Long id);
    ResponseEntity<Void> deleteStep(Long id);
}
