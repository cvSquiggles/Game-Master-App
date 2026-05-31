package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.Player;
import com.gamemaster.gmapp.dto.CreatePlayerRequest;
import com.gamemaster.gmapp.service.GameSessionService;
import com.gamemaster.gmapp.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PlayerController {

    private PlayerService playerService; // Service layer for handling business logic related to Player entities

    public PlayerController(PlayerService playerService) { this.playerService = playerService; } // Constructor injection for the PlayerService

    // Endpoint to retrieve all players, delegating to the service layer
    @GetMapping("/api/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // Endpoint to retrieve a specific player by their unique ID, delegating to the service layer
    @GetMapping("/api/players/{id}")
    public Optional<Player> findById(@PathVariable UUID id) {
        return playerService.findById(id);
    }

    /* Endpoint to create a new player, delegating to the service layer. Because session_id on the GameSession Entity is
    * not nullable, the incoming Player object must include a valid GameSession reference to succeed.
    * Implementing a DTO CreatePlayerRequest to try and make this work.
     */
    @PostMapping("/api/players")
    public Player createPlayer(@RequestBody CreatePlayerRequest createPlayerRequest) {
        return playerService.createPlayer(createPlayerRequest);
    }
}
