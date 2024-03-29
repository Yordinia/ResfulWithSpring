package com.restwithspring.services;

import com.restwithspring.repositories.EndStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndStepService {
    private final EndStepRepository endStepRepository;

    @Autowired
    public EndStepService(EndStepRepository endStepRepository) {
        this.endStepRepository = endStepRepository;
    }
}
