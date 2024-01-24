package com.restwithspring.controlles.services;

import com.restwithspring.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StepService {
    private final StepRepository stepRepository;
    @Autowired
    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    // get all
    public List<Step> getAllSteps(){
        return stepRepository.findAll();
    }

    // find id
    public ResponseEntity<Step> getStepById(Long id){
        Optional<Step> optionalStep = stepRepository.findById(id);
        return optionalStep.map(step -> new ResponseEntity<>(step, HttpStatus.NOT_FOUND))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // post
    public ResponseEntity<Step> postStep(Step step){
        stepRepository.save(step);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // edit
    public ResponseEntity<Step> updateStep( Long id, Step newStep){
        Optional<Step> optionalStep = stepRepository.findById(id);
        String newType = newStep.getType();
        return optionalStep.map(step ->{
            step.setType(newType);
            return new ResponseEntity<>(step, HttpStatus.OK);
        } ).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // delete
    public ResponseEntity<Void> deleteStep( Long id){
        if (stepRepository.existsById(id)){
            stepRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
