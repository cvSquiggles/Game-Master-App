package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateTemplateViewRequest;
import com.gamemaster.gmapp.model.TemplateView;
import com.gamemaster.gmapp.service.TemplateViewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemplateViewController {
    private TemplateViewService templateViewService;

    public TemplateViewController(TemplateViewService templateViewService){
        this.templateViewService = templateViewService;
    }

    @GetMapping("/api/template-views")
    public List<TemplateView> getAllTemplateViews() {
        return templateViewService.getAllTemplateViews();
    }

    @PostMapping("/api/template-views")
    public TemplateView saveTemplateView(@RequestBody CreateTemplateViewRequest createTemplateViewRequest) {
        return templateViewService.saveTemplateView(createTemplateViewRequest);
    }

}
