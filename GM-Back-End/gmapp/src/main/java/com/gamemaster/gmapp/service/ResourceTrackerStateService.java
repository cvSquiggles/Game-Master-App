package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateResourceTrackerStateRequest;
import com.gamemaster.gmapp.model.ComponentInstance;
import com.gamemaster.gmapp.model.ResourceTrackerState;
import com.gamemaster.gmapp.repository.ResourceTrackerStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceTrackerStateService {

    private ResourceTrackerStateRepository resourceTrackerStateRepository;
    private ComponentInstanceService componentInstanceService;

    public ResourceTrackerStateService(ResourceTrackerStateRepository resourceTrackerStateRepository, ComponentInstanceService componentInstanceService) {
        this.resourceTrackerStateRepository = resourceTrackerStateRepository;
        this.componentInstanceService = componentInstanceService;
    }

    public List<ResourceTrackerState> getAllResourceTrackerStates() {
        return resourceTrackerStateRepository.findAll();
    }

    public ResourceTrackerState saveResourceTrackerState(CreateResourceTrackerStateRequest request) {

        ComponentInstance componentInstance = componentInstanceService.findById(request.getComponentInstanceId()).orElseThrow(()-> new RuntimeException("Component instance not found for id: " + request.getComponentInstanceId()));

        ResourceTrackerState resourceTrackerState = new ResourceTrackerState();
        resourceTrackerState.setComponentInstance(componentInstance);
        resourceTrackerState.setResourceName(request.getResourceName());
        resourceTrackerState.setUnitLabel(request.getUnitLabel());
        resourceTrackerState.setCurrentValue(request.getCurrentValue());
        resourceTrackerState.setMaxValue(request.getMaxValue());
        resourceTrackerState.setMinValue(request.getMinValue());
        resourceTrackerState.setStepSize(request.getStepSize());

        return resourceTrackerStateRepository.save(resourceTrackerState);
    }
}
