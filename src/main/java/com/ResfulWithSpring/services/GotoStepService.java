package com.ResfulWithSpring.services;

import com.ResfulWithSpring.repositories.GotoStepRepository;
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
