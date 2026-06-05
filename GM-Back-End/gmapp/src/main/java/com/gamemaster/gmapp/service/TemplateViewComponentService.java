package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateTemplateViewComponentRequest;
import com.gamemaster.gmapp.model.TemplateComponent;
import com.gamemaster.gmapp.model.TemplateView;
import com.gamemaster.gmapp.model.TemplateViewComponent;
import com.gamemaster.gmapp.model.embeddable.TemplateViewComponentId;
import com.gamemaster.gmapp.repository.TemplateViewComponentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TemplateViewComponentService {

    private TemplateViewComponentRepository templateViewComponentRepository;
    private TemplateViewService templateViewService;
    private TemplateComponentService templateComponentService;

    public TemplateViewComponentService(TemplateViewComponentRepository templateViewComponentRepository,
                                 TemplateViewService templateViewService,
                                 TemplateComponentService templateComponentService)
    {
        this.templateComponentService = templateComponentService;
        this.templateViewService = templateViewService;
        this.templateViewComponentRepository = templateViewComponentRepository;
    }

    public List<TemplateViewComponent> getAllTemplateViewComponents(){
        return templateViewComponentRepository.findAll();
    }

    public TemplateViewComponent saveTemplateViewComponent(CreateTemplateViewComponentRequest request)
    {
        TemplateView templateView = templateViewService.findById(request.getTemplateViewId()).orElseThrow(() -> new RuntimeException("Template view not found with id: " + request.getTemplateViewId()));
        TemplateComponent templateComponent = templateComponentService.findById(request.getTemplateComponentId()).orElseThrow(() -> new RuntimeException("Template component not found with id: " + request.getTemplateComponentId()));

        TemplateViewComponentId templateViewComponentId = new TemplateViewComponentId(templateView.getId(), templateComponent.getId());

        TemplateViewComponent templateViewComponent = new TemplateViewComponent();
        templateViewComponent.setTemplateComponent(templateComponent);
        templateViewComponent.setTemplateView(templateView);
        templateViewComponent.setTemplateViewComponentId(templateViewComponentId);
        templateViewComponent.setPosition(request.getPosition());

        return templateViewComponentRepository.save(templateViewComponent);
    }


}
