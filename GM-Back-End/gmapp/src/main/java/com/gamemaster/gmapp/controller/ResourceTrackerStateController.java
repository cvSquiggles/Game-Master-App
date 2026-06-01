package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateResourceTrackerStateRequest;
import com.gamemaster.gmapp.model.ResourceTrackerState;
import com.gamemaster.gmapp.service.ResourceTrackerStateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceTrackerStateController {
    private ResourceTrackerStateService resourceTrackerStateService;

    public ResourceTrackerStateController(ResourceTrackerStateService resourceTrackerStateService) {
        this.resourceTrackerStateService = resourceTrackerStateService;
    }

    @GetMapping("/api/resource-tracker-states")
    public List<ResourceTrackerState> getAllResourceTrackerStates() {
        return resourceTrackerStateService.getAllResourceTrackerStates();
    }

    @PostMapping("/api/resource-tracker-states")
    public ResourceTrackerState saveResourceTrackerState(@RequestBody CreateResourceTrackerStateRequest request) {
        return resourceTrackerStateService.saveResourceTrackerState(request);
    }
}
