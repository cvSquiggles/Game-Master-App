package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.ScoreTrackerState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScoreTrackerStateRepository extends JpaRepository<ScoreTrackerState, UUID> {
    //Intentionally left empty for now...
}
