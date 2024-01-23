package com.restwithspring.controlles;


import com.restwithspring.Flow;
import com.restwithspring.controlles.services.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/flow")
public class FlowControllers {
    private final FlowService flowService;
    @Autowired
    public FlowControllers(FlowService flowService) {
        this.flowService = flowService;
    }

    @GetMapping("/get-all")
    public List<Flow> getAllFlows(){
        return flowService.getAllFlows();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Flow> getFlowById(@PathVariable Long id){
        return flowService.getFlowById(id);
    }
    // Posting
    @PostMapping
    public ResponseEntity<Flow> setFlow(@RequestBody Flow flow) {
        return flowService.setFlow(flow);
    }

    // Editing / updating
    public ResponseEntity<Flow> updateFlow(@RequestBody Flow updatedFlow, @PathVariable Long id) {
       return flowService.updateFlow(updatedFlow, id);
    }

    // DELEting
    public ResponseEntity<String> deleteFlow(@PathVariable Long id) {
        return flowService.deleteFlow(id);
    }

}





