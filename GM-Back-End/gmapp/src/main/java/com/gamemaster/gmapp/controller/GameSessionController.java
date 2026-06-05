package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.model.GameSession;
import com.gamemaster.gmapp.service.GameSessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameSessionController {
    private GameSessionService gameSessionService;

    public GameSessionController(GameSessionService gameSessionService) { this.gameSessionService = gameSessionService; }

    @GetMapping("/api/game-sessions")
    public List<GameSession> getAllGameSessions() {
        return gameSessionService.getAllGameSessions();
    }

    @GetMapping("/api/game-sessions/{sessionCode}")
    public Optional<GameSession> getGameSessionBySessionCode(@PathVariable String sessionCode) {
        return gameSessionService.getGameSessionBySessionCode(sessionCode);
    }

    @PostMapping("/api/game-sessions")
    public GameSession saveGameSession(@RequestBody GameSession gameSession) {
        return gameSessionService.saveGameSession(gameSession);
    }
}
