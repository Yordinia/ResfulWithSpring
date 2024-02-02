package com.ResfulWithSpring.services;

import com.ResfulWithSpring.ServiceInterface.FlowServiceInterface;
import com.ResfulWithSpring.repositories.FlowRepository;
import com.ResfulWithSpring.models.Flow;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowService implements FlowServiceInterface {
    private final FlowRepository flowRepository;
    @Override
    public List<Flow> getAllFlows() {
        return flowRepository.findAll();
    }

    @Override
    public ResponseEntity<Flow> saveFlow(Flow flow) {
        Flow createdFlow = flowRepository.save(flow);
        return new ResponseEntity<>(createdFlow, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<Flow> findFlowById(Long id) {
        Optional<Flow> oFlow = flowRepository.findById(id);
        return oFlow.map(flow1-> new ResponseEntity<>(flow1, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
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