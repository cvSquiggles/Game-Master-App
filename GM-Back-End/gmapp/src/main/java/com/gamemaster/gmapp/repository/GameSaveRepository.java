package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.GameSave;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GameSaveRepository extends JpaRepository<GameSave, UUID> {
    List<GameSave> findByGameSession_Id(UUID sessionId); //Need derived query method to get all game saves by a provided game session id
}
