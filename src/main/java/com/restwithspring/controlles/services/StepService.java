package com.restwithspring.controlles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService {
    private final StepRepository stepRepository;
    @Autowired
    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }
}
