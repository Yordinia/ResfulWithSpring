package com.ResfulWithSpring.services;

import com.ResfulWithSpring.repositories.ChoiceStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceStepService {
    private final ChoiceStepRepository choiceStepRepository;
    @Autowired
    public ChoiceStepService(ChoiceStepRepository choiceStepRepository) {
        this.choiceStepRepository = choiceStepRepository;
    }
}
