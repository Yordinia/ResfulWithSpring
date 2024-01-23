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

    // GEt ALL FLOw
    @GetMapping("/get-all")


    public List<Flow> getAllFlows(){
        return flowService.getAllFlows();
    }

    // Find FLow By Id
    @GetMapping("/find/{id}")
    public ResponseEntity<Flow> getFlowById(@PathVariable Long id){
        return flowService.getFlowById(id);
    }
    // Posting
    @PostMapping
    public ResponseEntity<Flow> setFlow(@RequestBody Flow flow){
    Flow createdFlow = flowRepository.save(flow);
    return new ResponseEntity<>(createdFlow, HttpStatus.CREATED);
    }
    // Editing / updating
    public ResponseEntity<Flow> updateFlow(@RequestBody Flow updatedFlow, @PathVariable Long id){
        Optional<Flow> optFlow = flowRepository.findById(id);
        return optFlow.map(flow1 ->{
            String newName = updatedFlow.getName();
            flow1.setName(newName);
            return new ResponseEntity<>(flow1, HttpStatus.OK);
        } ).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // DELEting
    public ResponseEntity<String> deleteFlow(@PathVariable Long id){
        if(flowRepository.existsById(id)){
            flowRepository.deleteById(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}





