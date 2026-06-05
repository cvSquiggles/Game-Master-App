package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateTemplateViewRequest;
import com.gamemaster.gmapp.model.GameTemplate;
import com.gamemaster.gmapp.model.TemplateView;
import com.gamemaster.gmapp.repository.GameTemplateRepository;
import com.gamemaster.gmapp.repository.TemplateViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TemplateViewService {
    
    private TemplateViewRepository templateViewRepository;
    private GameTemplateRepository gameTemplateRepository;
    
    public TemplateViewService (TemplateViewRepository templateViewRepostiory, GameTemplateRepository gameTemplateRepository) {
        this.templateViewRepository = templateViewRepostiory;
        this.gameTemplateRepository = gameTemplateRepository;
    }
    
    public List<TemplateView> getAllTemplateViews() {
        return templateViewRepository.findAll();
    }

    public Optional<TemplateView> findById(UUID id) {
        return templateViewRepository.findById(id);
    }
    
    public TemplateView saveTemplateView(CreateTemplateViewRequest createTemplateViewRequest) {
        GameTemplate gameTemplate = gameTemplateRepository.findById(createTemplateViewRequest.getGameTemplateId()).orElseThrow(() -> new RuntimeException("Game template not found with id: " + createTemplateViewRequest.getGameTemplateId()));
        
        //Just realized I'm throwing the exception here, but I would probably want to...handle it at some point as well.

        TemplateView templateView = new TemplateView();
        templateView.setGameTemplate(gameTemplate);
        templateView.setName(createTemplateViewRequest.getName());
        templateView.setIcon(createTemplateViewRequest.getIcon());
        templateView.setDisplayOrder(createTemplateViewRequest.getDisplayOrder());

        return templateViewRepository.save(templateView);
    }
    
}
