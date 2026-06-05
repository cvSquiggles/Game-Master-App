package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateSessionViewRequest;
import com.gamemaster.gmapp.model.SessionView;
import com.gamemaster.gmapp.service.SessionViewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionViewController {

    private SessionViewService sessionViewService;

    public SessionViewController(SessionViewService sessionViewService)
    {
        this.sessionViewService = sessionViewService;
    }

    @GetMapping("/api/session-views")
    public List<SessionView> getAllSessionViews()
    {
        return sessionViewService.getAllSessionViews();
    }

    @PostMapping("/api/session-views")
    public SessionView saveSessionView(@RequestBody CreateSessionViewRequest createSessionViewRequest)
    {
        return sessionViewService.saveSessionView(createSessionViewRequest);
    }

}
