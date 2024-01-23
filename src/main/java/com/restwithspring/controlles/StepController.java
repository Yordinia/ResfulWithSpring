package com.restwithspring.controlles;

import com.restwithspring.Step;
import com.restwithspring.controlles.services.StepRepository;
import com.restwithspring.controlles.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/steps")
public class StepController {
    private final StepService stepService;
    @Autowired
    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    // Get all steps
    @GetMapping("/get-all")
    public List<Step> getAllSteps(){
        return stepService.getAllSteps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Step> getStepById(@PathVariable Long id) {
        return stepService.getStepById(id);
    }

    // post a step
    @PostMapping
    public ResponseEntity<Step> postStep(@RequestBody Step step) {
        return stepService.postStep(step);
    }

    // update  a step
    @PutMapping
    public ResponseEntity<Step> updateStep(@PathVariable Long id, @RequestBody Step newStep) {
        return stepService.updateStep(id, newStep);
    }

    // delete a step
    @DeleteMapping
    public ResponseEntity deleteStep(@PathVariable Long id) {
        return stepService.deleteStep(id);
    }

}
















