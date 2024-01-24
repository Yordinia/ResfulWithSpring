package com.restwithspring.controlles;

import com.restwithspring.Step;
import com.restwithspring.controlles.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/steps")
public class StepController {
    private final StepService stepService;
    @Autowired
    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    // Get all steps
    @GetMapping
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
    @PutMapping("/{id}")
    public ResponseEntity<Step> updateStep(@PathVariable Long id, @RequestBody Step newStep) {
        return stepService.updateStep(id, newStep);
    }

    // delete a step
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStep(@PathVariable Long id) {
        return stepService.deleteStep(id);
    }
}