package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.GameSave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameSaveRepository extends JpaRepository<GameSave, UUID> {
    //Intentionally left empty for now...
}
