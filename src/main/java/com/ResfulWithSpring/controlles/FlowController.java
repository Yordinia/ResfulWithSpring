package com.ResfulWithSpring.controlles;

import com.ResfulWithSpring.models.Flow;
import com.ResfulWithSpring.services.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flows")
public class FlowController {
    private final FlowService flowService;
    @Autowired
    public FlowController(FlowService flowService) {
        this.flowService = flowService;
    }
    // Get all flows
    @GetMapping("/all")
    public List<Flow> getAllFlows() {
        return flowService.getAllFlows();
    }
    // post a flow
    @PostMapping
    public ResponseEntity<Flow> saveFlow (@RequestBody Flow flow){
        return flowService.saveFlow(flow);
    }
    // find a flow by id
    @GetMapping("/{id}")
    public ResponseEntity<Flow> findFlowById(@PathVariable Long id) {
        return flowService.findFlowById(id);
    }
    // update  a flow

    @PutMapping("/{id}")
    public ResponseEntity<Flow> updateFlow (@PathVariable Long id, @RequestBody Flow newFlow){
        return flowService.updateFlow(newFlow, id);
    }
    // delete a flow
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlow (@PathVariable Long id){
        return flowService.deleteFlow(id);
    }
}