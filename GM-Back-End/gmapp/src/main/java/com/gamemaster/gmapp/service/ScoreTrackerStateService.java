package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateScoreTrackerStateRequest;
import com.gamemaster.gmapp.model.ComponentInstance;
import com.gamemaster.gmapp.model.ScoreTrackerState;
import com.gamemaster.gmapp.repository.ScoreTrackerStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreTrackerStateService {
    private ScoreTrackerStateRepository scoreTrackerStateRepository;
    private ComponentInstanceService componentInstanceService;

    public ScoreTrackerStateService(ScoreTrackerStateRepository scoreTrackerStateRepository, ComponentInstanceService componentInstanceService) {
        this.scoreTrackerStateRepository = scoreTrackerStateRepository;
        this.componentInstanceService = componentInstanceService;
    }

    public List<ScoreTrackerState> getAllScoreTrackerStates() {
        return scoreTrackerStateRepository.findAll();
    }

    public ScoreTrackerState saveScoreTrackerState(CreateScoreTrackerStateRequest request) {
        ComponentInstance componentInstance = componentInstanceService.findById(request.getComponentInstanceId()).orElseThrow(()-> new RuntimeException("Component instance not found for id: " + request.getComponentInstanceId()));

        ScoreTrackerState scoreTrackerState = new ScoreTrackerState();
        scoreTrackerState.setComponentInstance(componentInstance);
        scoreTrackerState.setCurrentScore(request.getCurrentScore());
        scoreTrackerState.setIncrementPresets(request.getIncrementPresets());
        scoreTrackerState.setAllowNegative(request.getAllowNegative());

        return scoreTrackerStateRepository.save(scoreTrackerState);
    }
}
