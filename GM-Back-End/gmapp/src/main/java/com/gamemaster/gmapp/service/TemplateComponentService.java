package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateTemplateComponentRequest;
import com.gamemaster.gmapp.model.GameTemplate;
import com.gamemaster.gmapp.model.TemplateComponent;
import com.gamemaster.gmapp.repository.TemplateComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateComponentService {
    private TemplateComponentRepository templateComponentRepository;
    private GameTemplateService gameTemplateService;

    public TemplateComponentService(TemplateComponentRepository templateComponentRepository, GameTemplateService gameTemplateService) {
        this.templateComponentRepository = templateComponentRepository;
        this.gameTemplateService = gameTemplateService;
    }

    public List<TemplateComponent> getAllTemplateComponents() {
        return templateComponentRepository.findAll();
    }

    public TemplateComponent saveTemplateComponent(CreateTemplateComponentRequest request) {
        GameTemplate gameTemplate = gameTemplateService.findById(request.getGameTemplateId()).orElseThrow(()-> new RuntimeException("GameTemplate not found with id: " + request.getGameTemplateId()));

        TemplateComponent templateComponent = new TemplateComponent();
        templateComponent.setGameTemplate(gameTemplate);
        templateComponent.setComponentType(request.getComponentType());
        templateComponent.setLabel(request.getLabel());
        templateComponent.setDefaultConfig(request.getDefaultConfig());
        templateComponent.setDisplayOrder(request.getDisplayOrder());

        return templateComponentRepository.save(templateComponent);
    }


}
