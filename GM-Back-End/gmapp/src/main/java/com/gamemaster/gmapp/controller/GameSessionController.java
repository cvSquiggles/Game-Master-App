package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.SaveGameSessionRequest;
import com.gamemaster.gmapp.model.GameSession;
import com.gamemaster.gmapp.service.GameSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @PostMapping("/api/game-sessions/create")
    public GameSession createGameSession(@RequestBody GameSession gameSession) {
        return gameSessionService.createGameSession(gameSession);
    }

    @PostMapping("/api/game-sessions/{id}/save")
    public ResponseEntity<GameSession> saveGameSession(@PathVariable UUID id, @RequestBody SaveGameSessionRequest request) {
        return gameSessionService.saveGameSession(id, request);
    }
}
