package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateRulesDocumentStateRequest;
import com.gamemaster.gmapp.model.RulesDocumentState;
import com.gamemaster.gmapp.service.RulesDocumentStateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RulesDocumentStateController {

    private RulesDocumentStateService rulesDocumentStateService; // Service layer for business logic

    public RulesDocumentStateController(RulesDocumentStateService rulesDocumentStateService) {
        this.rulesDocumentStateService = rulesDocumentStateService;
    }

    @GetMapping("/api/rules-document-states")
    public List<RulesDocumentState> getAllRulesDocumentStates() {
        return rulesDocumentStateService.getAllRulesDocumentStates();
    }

    @PostMapping("/api/rules-document-states")
    public RulesDocumentState saveRulesDocumentState(@RequestBody CreateRulesDocumentStateRequest request) {
        return rulesDocumentStateService.saveRulesDocumentState(request);
    }
}
