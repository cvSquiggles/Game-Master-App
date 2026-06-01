package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateScoreTrackerStateRequest;
import com.gamemaster.gmapp.model.ScoreTrackerState;
import com.gamemaster.gmapp.service.ScoreTrackerStateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreTrackerStateController {
    private ScoreTrackerStateService scoreTrackerStateService;

    public ScoreTrackerStateController(ScoreTrackerStateService scoreTrackerStateService) {
        this.scoreTrackerStateService = scoreTrackerStateService;
    }

    @GetMapping("/api/score-tracker-states")
    public List<ScoreTrackerState> getAllScoreTrackerStates() {
        return scoreTrackerStateService.getAllScoreTrackerStates();
    }

    @PostMapping("/api/score-tracker-states")
    public ScoreTrackerState saveScoreTrackerState(@RequestBody CreateScoreTrackerStateRequest request) {
        return scoreTrackerStateService.saveScoreTrackerState(request);
    }

}
