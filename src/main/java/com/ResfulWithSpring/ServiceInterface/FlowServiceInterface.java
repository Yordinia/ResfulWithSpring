package com.ResfulWithSpring.ServiceInterface;

import com.ResfulWithSpring.models.Flow;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FlowServiceInterface {
    List<Flow> getAllFlows();
    ResponseEntity<Flow> saveFlow(Flow flow);
    ResponseEntity<Flow> findFlowById(Long id);
    ResponseEntity<Flow> updateFlow(Flow flow, Long id);
    ResponseEntity<Void> deleteFlow(Long id);
}
