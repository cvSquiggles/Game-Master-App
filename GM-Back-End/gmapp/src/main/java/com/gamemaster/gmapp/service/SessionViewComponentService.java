package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateSessionViewComponentRequest;
import com.gamemaster.gmapp.model.ComponentInstance;
import com.gamemaster.gmapp.model.SessionView;
import com.gamemaster.gmapp.model.SessionViewComponent;
import com.gamemaster.gmapp.model.embeddable.SessionViewComponentId;
import com.gamemaster.gmapp.repository.SessionViewComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionViewComponentService {

    private SessionViewComponentRepository sessionViewComponentRepository;
    private SessionViewService sessionViewService;
    private ComponentInstanceService componentInstanceService;

    public SessionViewComponentService(SessionViewComponentRepository sessionViewComponentRepository,
                                       SessionViewService sessionViewService,
                                       ComponentInstanceService componentInstanceService) {
        this.sessionViewComponentRepository = sessionViewComponentRepository;
        this.sessionViewService = sessionViewService;
        this.componentInstanceService = componentInstanceService;
    }

    public List<SessionViewComponent> getAllSessionViewComponents() {
        return sessionViewComponentRepository.findAll();
    }

    public SessionViewComponent saveSessionViewComponent(CreateSessionViewComponentRequest request) {
        SessionView sessionView = sessionViewService.findById(request.getSessionViewId()).orElseThrow(() -> new RuntimeException("No Session view found with id: " + request.getSessionViewId()));
        ComponentInstance componentInstance = componentInstanceService.findById(request.getComponentInstanceId()).orElseThrow(() -> new RuntimeException("No Component instance found with id: " + request.getComponentInstanceId()));

        SessionViewComponentId sessionViewComponentId = new SessionViewComponentId(sessionView.getId(), componentInstance.getId());

        SessionViewComponent sessionViewComponent = new SessionViewComponent();
        sessionViewComponent.setComponentInstance(componentInstance);
        sessionViewComponent.setSessionView(sessionView);
        sessionViewComponent.setSessionViewComponentId(sessionViewComponentId);
        sessionViewComponent.setPosition(request.getPosition());

        return sessionViewComponentRepository.save(sessionViewComponent);
    }

}
