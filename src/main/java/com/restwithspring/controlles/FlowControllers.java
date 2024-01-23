package com.restwithspring.controlles;


import com.restwithspring.Flow;
import com.restwithspring.controlles.services.FlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flow")
public class FlowControllers {
    private final FlowRepository flowRepository;

    @Autowired
    public FlowControllers(FlowRepository flowRepository) {
        this.flowRepository = flowRepository;
    }

    // Find FLow By Id
    @GetMapping
    public ResponseEntity<Flow> getFlowById(@PathVariable Long id){
        Optional<Flow> oFlow = flowRepository.findById(id);
        return oFlow.map(flow1-> new ResponseEntity<>(flow1, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
    // GEt ALL FLOW
    public List<Flow> GetAllFlows(){
        return flowRepository.findAll();
    }
}





