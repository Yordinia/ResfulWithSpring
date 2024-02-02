package com.ResfulWithSpring.services;

import com.ResfulWithSpring.ServiceInterface.StepServiceInterface;
import com.ResfulWithSpring.models.Step;
import com.ResfulWithSpring.repositories.StepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StepService implements StepServiceInterface {
    private final StepRepository stepRepository;
    @Override
    public List<Step> getAllSteps() {
        return stepRepository.findAll();
    }

    @Override
    public ResponseEntity<Step> findStepById(Long id) {
        Optional<Step> oStep = stepRepository.findById(id);
        return oStep.map(step1-> new ResponseEntity<>(step1, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Override
    public ResponseEntity<Step> saveStep(Step step) {
        Step createdStep = stepRepository.save(step);
        return new ResponseEntity<>(createdStep, HttpStatus.CREATED);
    }
    public ResponseEntity<Step> updateStep(Step updatedStep, Long id){
        Optional<Step> optStep = stepRepository.findById(id);
        return optStep.map(step1 ->{
            String newName = updatedStep.getDescription();
            step1.setDescription(newName);
            return new ResponseEntity<>(step1, HttpStatus.OK);
        } ).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Void> deleteStep(Long id){
        if(stepRepository.existsById(id)){
            stepRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.notFound().build();
    }
    
}
