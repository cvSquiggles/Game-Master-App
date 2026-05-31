package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.GameSession;
import com.gamemaster.gmapp.repository.GameSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameSessionService {

    private GameSessionRepository gameSessionRepository;

    public GameSessionService(GameSessionRepository gameSessionRepository) { this.gameSessionRepository = gameSessionRepository; }

    public List<GameSession> getAllGameSessions()
    {
        return gameSessionRepository.findAll();
    }

    public Optional<GameSession> getGameSessionBySessionCode(String sessionCode)
    {
        return gameSessionRepository.findBySessionCode(sessionCode);
    }

    public GameSession saveGameSession(GameSession gameSession)
    {
        return gameSessionRepository.save(gameSession);
    }

}
