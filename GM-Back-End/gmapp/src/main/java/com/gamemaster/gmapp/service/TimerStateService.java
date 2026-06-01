package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateTimerStateRequest;
import com.gamemaster.gmapp.model.ComponentInstance;
import com.gamemaster.gmapp.model.TimerState;
import com.gamemaster.gmapp.repository.TimerStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimerStateService {

    private TimerStateRepository timerStateRepository;
    private ComponentInstanceService componentInstanceService;

    public TimerStateService(TimerStateRepository timerStateRepository, ComponentInstanceService componentInstanceService) {
        this.timerStateRepository = timerStateRepository;
        this.componentInstanceService = componentInstanceService;
    }

    public List<TimerState> getAllTimerStates() {
        return timerStateRepository.findAll();
    }

    public TimerState saveTimerState(CreateTimerStateRequest request) {
        ComponentInstance componentInstance = componentInstanceService.findById(request.getComponentInstanceId()).orElseThrow(()-> new RuntimeException("ComponentInstance not found with id: " + request.getComponentInstanceId()));

        TimerState timerState = new TimerState();
        timerState.setComponentInstance(componentInstance);
        timerState.setMode(request.getMode());
        timerState.setCurrentValueMs(request.getCurrentValueMs());
        timerState.setBufferMs(request.getBufferMs());
        timerState.setMinMs(request.getMinMs());
        timerState.setMaxMs(request.getMaxMs());
        timerState.setRandomizeStart(request.getRandomizeStart());
        timerState.setStatus(request.getStatus());
        timerState.setLastTickAt(request.getLastTickAt());

        return timerStateRepository.save(timerState);
    }

}
