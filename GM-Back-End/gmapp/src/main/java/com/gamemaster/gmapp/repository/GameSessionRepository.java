package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import java.util.UUID;

public interface GameSessionRepository extends JpaRepository<GameSession, UUID> {
    //Including derived query method to find a GameSession by its session code, which is a unique identifier for each game session. Don't know exaclty how this works yet.
    public Optional<GameSession> findBySessionCode(String sessionCode);
}
