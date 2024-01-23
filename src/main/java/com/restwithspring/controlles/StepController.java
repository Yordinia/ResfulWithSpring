package com.restwithspring.controlles;

import com.restwithspring.Step;
import com.restwithspring.controlles.services.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/steps")
public class StepController {
    private final StepRepository stepRepository;
    @Autowired
    public StepController(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }
    // Get all steps
    @GetMapping("/get-all")
    public List<Step> getAllSteps(){
        return stepRepository.findAll();
    }

    // Get step by id
    @GetMapping("/{id}")
    public ResponseEntity<Step> getStepById(@PathVariable Long id){
        Optional<Step> optionalStep = stepRepository.findById(id);
        return optionalStep.map(step -> new ResponseEntity<>(step, HttpStatus.NOT_FOUND))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // post a step
    @PostMapping
    public ResponseEntity<Step> postStep(@RequestBody Step step){
        stepRepository.save(step);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // update  a step
    @PutMapping
    public ResponseEntity<Step> updateStep(@PathVariable Long id, @RequestBody Step newStep){
        Optional<Step> optionalStep = stepRepository.findById(id);
        String newType = newStep.getType();
        return optionalStep.map(step ->{
            step.setType(newType);
            return new ResponseEntity<>(step, HttpStatus.OK);
        } ).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // delete a step
    @DeleteMapping
    public ResponseEntity deleteStep(@PathVariable Long id){
        if (stepRepository.existsById(id)){
            stepRepository.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
















