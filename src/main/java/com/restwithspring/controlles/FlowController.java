package com.restwithspring.controlles;

import com.restwithspring.Flow;
import com.restwithspring.controlles.services.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/flows")
public class FlowController {
    private final FlowService flowService;
    @Autowired
    public FlowController(FlowService flowService) {
        this.flowService = flowService;
    }

    @GetMapping
    public List<Flow> getAllFlows(){
        return flowService.getAllFlows();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flow> getFlowById(@PathVariable Long id){
        return flowService.getFlowById(id);
    }
    // Posting
    @PostMapping
    public ResponseEntity<Flow> saveFlow(@RequestBody Flow flow) {
        return flowService.saveFlow(flow);
    }
    // Editing / updating
    @PutMapping("/{id}")
    public ResponseEntity<Flow> updateFlow(@RequestBody Flow updatedFlow, @PathVariable Long id) {
       return flowService.updateFlow(updatedFlow, id);
    }
    // DELEting
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlow(@PathVariable Long id) {
        return flowService.deleteFlow(id);
    }
}





