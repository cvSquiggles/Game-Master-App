package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.TimerState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimerStateRepository extends JpaRepository<TimerState, UUID> {
    //Intentionally left empty for now...
}
