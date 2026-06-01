package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateTemplateComponentRequest;
import com.gamemaster.gmapp.model.TemplateComponent;
import com.gamemaster.gmapp.service.TemplateComponentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemplateComponentController {

    private TemplateComponentService templateComponentService;

    public TemplateComponentController(TemplateComponentService templateComponentService) {
        this.templateComponentService = templateComponentService;
    }

    @GetMapping("/api/template-components")
    public List<TemplateComponent> getAllTemplateComponents() {
        return templateComponentService.getAllTemplateComponents();
    }

    @PostMapping("/api/template-components")
    public TemplateComponent createTemplateComponent(@RequestBody CreateTemplateComponentRequest request) {
        return templateComponentService.saveTemplateComponent(request);
    }

}
