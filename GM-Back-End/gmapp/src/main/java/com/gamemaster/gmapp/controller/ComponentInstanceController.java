package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateComponentInstanceRequest;
import com.gamemaster.gmapp.model.ComponentInstance;
import com.gamemaster.gmapp.service.ComponentInstanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComponentInstanceController {

    private ComponentInstanceService componentInstanceService; // Service layer for business logic

    public ComponentInstanceController(ComponentInstanceService componentInstanceService) {
        this.componentInstanceService = componentInstanceService;
    }

    @GetMapping("/api/component-instances")
    public List<ComponentInstance> getAllComponentInstances() {
        return componentInstanceService.getAllComponentInstances();
    }

    @PostMapping("/api/component-instances")
    public ComponentInstance saveComponentInstance(@RequestBody CreateComponentInstanceRequest request) {
        return componentInstanceService.saveComponentInstance(request);
    }
}
