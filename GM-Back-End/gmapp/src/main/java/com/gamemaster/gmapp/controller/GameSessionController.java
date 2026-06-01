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

    @GetMapping("/api/gamesessions")
    public List<GameSession> getAllGameSessions() {
        return gameSessionService.getAllGameSessions();
    }

    @GetMapping("/api/gamesessions/{sessionCode}")
    public Optional<GameSession> getGameSessionBySessionCode(@PathVariable String sessionCode) {
        return gameSessionService.getGameSessionBySessionCode(sessionCode);
    }

    @PostMapping("/api/gamesessions")
    public GameSession saveGameSession(@RequestBody GameSession gameSession) {
        return gameSessionService.saveGameSession(gameSession);
    }
}
