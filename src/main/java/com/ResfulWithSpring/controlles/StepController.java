package com.ResfulWithSpring.controlles;

import com.ResfulWithSpring.models.Step;
import com.ResfulWithSpring.services.StepService;
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
    @GetMapping("/all")
    public List<Step> getAllSteps() {
        return stepService.getAllSteps();
    }
        // find a step by id
    @GetMapping("/{id}")
    public ResponseEntity<Step> findStepById(@PathVariable Long id) {
        return stepService.findStepById(id);
    }
        // post a step
    @PostMapping
    public ResponseEntity<Step> saveStep (@RequestBody Step step){
            return stepService.saveStep(step);
        }
        // update  a step

    @PutMapping("/{id}")
    public ResponseEntity<Step> updateStep (@PathVariable Long id, @RequestBody Step newStep){
            return stepService.updateStep(newStep, id);
        }

        // delete a step
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStep (@PathVariable Long id){
            return stepService.deleteStep(id);
        }
}