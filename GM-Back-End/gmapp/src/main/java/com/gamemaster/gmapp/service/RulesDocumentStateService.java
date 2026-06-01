package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateRulesDocumentStateRequest;
import com.gamemaster.gmapp.model.ComponentInstance;
import com.gamemaster.gmapp.model.RulesDocumentState;
import com.gamemaster.gmapp.repository.RulesDocumentStateRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RulesDocumentStateService {

    private RulesDocumentStateRepository rulesDocumentStateRepository;
    private ComponentInstanceService componentInstanceService;

    public RulesDocumentStateService(RulesDocumentStateRepository rulesDocumentStateRepository, ComponentInstanceService componentInstanceService) {
        this.rulesDocumentStateRepository = rulesDocumentStateRepository;
        this.componentInstanceService = componentInstanceService;
    }

    public List<RulesDocumentState> getAllRulesDocumentStates() {
        return rulesDocumentStateRepository.findAll();
    }

    public RulesDocumentState saveRulesDocumentState(CreateRulesDocumentStateRequest request) {
        ComponentInstance componentInstance = componentInstanceService.findById(request.getComponentInstanceId()).orElseThrow(()-> new RuntimeException("Component instance not found for id: " + request.getComponentInstanceId()));

        RulesDocumentState rulesDocumentState = new RulesDocumentState();
        rulesDocumentState.setComponentInstance(componentInstance);
        rulesDocumentState.setTitle(request.getTitle());
        rulesDocumentState.setContentMarkdown(request.getContentMarkdown());
        rulesDocumentState.setVersion(request.getVersion());

        return rulesDocumentStateRepository.save(rulesDocumentState);
    }

}
