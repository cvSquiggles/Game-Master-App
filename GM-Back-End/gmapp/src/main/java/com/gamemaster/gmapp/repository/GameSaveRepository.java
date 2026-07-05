package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.GameSave;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GameSaveRepository extends JpaRepository<GameSave, UUID> {
    List<GameSave> findByGameSession_Id(UUID sessionId); //Need derived query method to get all game saves by a provided game session id

    List<GameSave> findByGameSession_SessionCode(String gameSessionCode); //Derived query to pull game session via game session code

    GameSave findTopByGameSession_IdOrderByCreatedAtDesc(UUID id); //Derived query to pull the latest game save for a given game session id
}
