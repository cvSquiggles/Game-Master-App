package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.ResourceTrackerState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResourceTrackerStateRepository extends JpaRepository<ResourceTrackerState, UUID> {
    //Intenionally left empty for now
}
