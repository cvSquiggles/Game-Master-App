package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.CreateTimerStateRequest;
import com.gamemaster.gmapp.model.TimerState;
import com.gamemaster.gmapp.service.TimerStateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimerStateController {

    private TimerStateService timerStateService;

    public TimerStateController(TimerStateService timerStateService) {
        this.timerStateService = timerStateService;
    }

    @GetMapping("/api/timer-states")
    public List<TimerState> getAllTimerStates() {
        return timerStateService.getAllTimerStates();
    }

    @PostMapping("/api/timer-states")
    public TimerState createTimerState(@RequestBody CreateTimerStateRequest request) {
        return timerStateService.saveTimerState(request);
    }

}
