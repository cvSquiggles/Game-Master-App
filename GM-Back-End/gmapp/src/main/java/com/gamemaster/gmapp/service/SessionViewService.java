package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateSessionViewRequest;
import com.gamemaster.gmapp.model.GameSession;
import com.gamemaster.gmapp.model.SessionView;
import com.gamemaster.gmapp.repository.SessionViewRepository;

import java.util.List;

public class SessionViewService {

    private SessionViewRepository sessionViewRepository;
    private GameSessionService gameSessionService;

    public SessionViewService(SessionViewRepository sessionViewRepository, GameSessionService gameSessionService) {
        this.sessionViewRepository = sessionViewRepository;
        this.gameSessionService = gameSessionService;
    }

    public List<SessionView> getAllSessionViews() {
        return sessionViewRepository.findAll();
    }

    public SessionView saveSessionView(CreateSessionViewRequest createSessionViewRequest) {
        GameSession gameSession = gameSessionService.findById(createSessionViewRequest.getGameSessionId()).orElseThrow(() -> new RuntimeException("GameSession not found with id: " + createSessionViewRequest.getGameSessionId()));

        SessionView sessionView = new SessionView();
        sessionView.setGameSession(gameSession);
        sessionView.setName(createSessionViewRequest.getName());
        sessionView.setIcon(createSessionViewRequest.getIcon());
        sessionView.setDisplayOrder(createSessionViewRequest.getDisplayOrder());

        return sessionViewRepository.save(sessionView);
    }


}
