package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateTemplateViewComponentRequest;
import com.gamemaster.gmapp.model.TemplateViewComponent;
import com.gamemaster.gmapp.service.TemplateViewComponentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemplateViewComponentController {
    private TemplateViewComponentService templateViewComponentService;

    public TemplateViewComponentController(TemplateViewComponentService templateViewComponentService){ this.templateViewComponentService = templateViewComponentService; }

    @GetMapping("/api/template-view-components")
    public List<TemplateViewComponent> getAllTemplateViewComponents() {
        return templateViewComponentService.getAllTemplateViewComponents();
    }

    @PostMapping("/api/template-view-components")
    public TemplateViewComponent saveTemplateViewComponent(@RequestBody CreateTemplateViewComponentRequest request) {
        return templateViewComponentService.saveTemplateViewComponent(request);
    }

}
