package com.restwithspring.controlles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GotoStepService {
    private final GotoStepRepository gotoStepRepository;
    @Autowired
    public GotoStepService(GotoStepRepository gotoStepRepository) {
        this.gotoStepRepository = gotoStepRepository;
    }
}
