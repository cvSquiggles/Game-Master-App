package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.dto.SaveGameSessionRequest;
import com.gamemaster.gmapp.model.GameSave;
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

    //Get Mappings
    @GetMapping("/api/game-sessions")
    public List<GameSession> getAllGameSessions() {
        return gameSessionService.getAllGameSessions();
    }

    @GetMapping("/api/game-sessions/{gameSessionCode}")
    public Optional<GameSession> getGameSessionBySessionCode(@PathVariable String gameSessionCode) {
        return gameSessionService.getGameSessionBySessionCode(gameSessionCode);
    }

    /**
     * Return all the save states for a given game session id
     * @param id
     * @return
     */
    @GetMapping("/api/game-sessions/{id}/saves")
    public List<GameSave> getGameSavesBySessionId(@PathVariable UUID id)
    {
        return gameSessionService.findByGameSession_Id(id);
    }

    //Note: this is a post mapping despite being a load because it updates the active_session_token, and last_update_stamp on the game session
    @PostMapping("/api/game-sessions/{gameSessionCode}/load")
    public GameSession loadGameSession(@PathVariable String gameSessionCode) {
        return gameSessionService.loadGameSession(gameSessionCode);
    }

    //Post Mappings
    @PostMapping("/api/game-sessions/create")
    public GameSession createGameSession(@RequestBody GameSession gameSession) {
        return gameSessionService.createGameSession(gameSession);
    }

    @PostMapping("/api/game-sessions/{id}/save")
    public ResponseEntity<GameSession> saveGameSession(@PathVariable UUID id, @RequestBody SaveGameSessionRequest request) {
        return gameSessionService.saveGameSession(id, request);
    }
}
