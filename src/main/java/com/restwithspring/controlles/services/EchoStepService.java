package com.restwithspring.controlles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EchoStepService {
    private final EchoStepRepository echoStepRepository;
    @Autowired
    public EchoStepService(EchoStepRepository echoStepRepository) {
        this.echoStepRepository = echoStepRepository;
    }
}
