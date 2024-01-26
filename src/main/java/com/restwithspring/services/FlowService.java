package com.restwithspring.services;

import com.restwithspring.repositories.FlowRepository;
import com.restwithspring.models.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowService {
    private final FlowRepository flowRepository;

    @Autowired
    public FlowService(FlowRepository flowRepository) {
        this.flowRepository = flowRepository;
    }

    public List<Flow> getAllFlows(){
        return flowRepository.findAll();
    }

    public ResponseEntity<Flow> getFlowById(Long id){
        Optional<Flow> oFlow = flowRepository.findById(id);
        return oFlow.map(flow1-> new ResponseEntity<>(flow1, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Flow> saveFlow(Flow flow){
        Flow createdFlow = flowRepository.save(flow);
        return new ResponseEntity<>(createdFlow, HttpStatus.CREATED);
    }

    public ResponseEntity<Flow> updateFlow(Flow updatedFlow, Long id){
        Optional<Flow> optFlow = flowRepository.findById(id);
        return optFlow.map(flow1 ->{
            String newName = updatedFlow.getName();
            flow1.setName(newName);
            return new ResponseEntity<>(flow1, HttpStatus.OK);
        } ).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Void> deleteFlow(Long id){
        if(flowRepository.existsById(id)){
            flowRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.notFound().build();
    }
}
