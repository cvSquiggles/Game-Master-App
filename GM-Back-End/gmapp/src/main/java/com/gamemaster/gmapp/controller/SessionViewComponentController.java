package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateSessionViewComponentRequest;
import com.gamemaster.gmapp.model.SessionViewComponent;
import com.gamemaster.gmapp.service.SessionViewComponentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionViewComponentController {
    private SessionViewComponentService sessionViewComponentService;

    public SessionViewComponentController(SessionViewComponentService sessionViewComponentService) {
        this.sessionViewComponentService = sessionViewComponentService;
    }

    @GetMapping("/api/session-view-components")
    public List<SessionViewComponent> getAllSessionViewComponents() {
        return sessionViewComponentService.getAllSessionViewComponents();
    }

    @PostMapping("/api/session-view-components")
    public SessionViewComponent saveSessionViewComponent(@RequestBody CreateSessionViewComponentRequest request) {
        return sessionViewComponentService.saveSessionViewComponent(request);
    }
}
