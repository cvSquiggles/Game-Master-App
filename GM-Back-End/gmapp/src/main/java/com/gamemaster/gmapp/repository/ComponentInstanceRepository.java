package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.ComponentInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComponentInstanceRepository extends JpaRepository<ComponentInstance, UUID> {
    //Left empty for now...
}
