package com.restwithspring.controlles.services;

import com.restwithspring.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
}
