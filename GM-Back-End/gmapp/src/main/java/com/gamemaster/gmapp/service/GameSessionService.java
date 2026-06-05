package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.controller.GameSessionController;
import com.gamemaster.gmapp.dto.SaveGameSessionRequest;
import com.gamemaster.gmapp.model.GameSession;
import com.gamemaster.gmapp.repository.GameSessionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameSessionService {

    //String of acceptable characters for use in generating game session codes
    private static final String ACCEPTABLE_CHARACTERS = "ABCDEFGHIJKLMONPQRSTUVWXYZ123456789";
    //SecureRandom instance to use for game code generation
    private static final SecureRandom secureRandom = new SecureRandom();

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

    public Optional<GameSession> findById(UUID id) {
        return gameSessionRepository.findById(id);
    }

    /**
     * Using ResponseEntity return type allows returning a 409 error if the active session token submitted is invalid
     * @param id this is the id of the game session that we're attempting to update
     * @param request this contains the active session token that the save is being submitted from, so to speak
     * @return ReponseEntity<GameSession> - Empty 409 if failed token validation, otherwise a 200 containing the result of the save in the body
     */
    public ResponseEntity<GameSession> saveGameSession(UUID id, SaveGameSessionRequest request)
    {
        //First off, we need to look up the game session associated with the id provided
        GameSession gameSession = gameSessionRepository.findById(id).orElseThrow(()-> new RuntimeException("Failed to find game session corresponding to the id: " + id + " while attempting to save a game."));

        //Then check to see if the active session token submitted in the request matches the one on the game session in the database
        if(!gameSession.getActiveSessionToken().equals(request.getActiveSessionToken()))
        {
            return ResponseEntity.status(409).build(); //The token is stale and/or incorrect
        }

        //TODO: Currently not actually applying any of the JSONBlob game state change stuff, but will eventually need to go here since save currently does nothing meaningful.

        gameSession.setLastActiveAt(LocalDateTime.now()); //Update to the time of this save

        return ResponseEntity.ok(gameSessionRepository.save(gameSession));
    }

    public GameSession createGameSession(GameSession gameSession)
    {
        String sessionCode = generateGameSessionCode(); //Generate a unique random session code for this game
        gameSession.setSessionCode(sessionCode);
        gameSession.setActiveSessionToken(UUID.randomUUID());

        return gameSessionRepository.save(gameSession);
    }

    private String generateGameSessionCode() {
        return generateGameSessionCode(1);
    }

    private String generateGameSessionCode(int attempt) {



        StringBuilder code = new StringBuilder();

        //Pick through acceptable characters at random and append them to our code string until we have 8
        while(code.length() < 8)
        {
            int randomIndex = secureRandom.nextInt(ACCEPTABLE_CHARACTERS.length());
            code.append(ACCEPTABLE_CHARACTERS.charAt(randomIndex));
        }

        //Check to see if this game code already exists
        Optional<GameSession> sessionCode = gameSessionRepository.findBySessionCode(code.toString());

        if ( !sessionCode.isEmpty() ) //If our search didn't turn up empty, then we found a matching code
        {
            if ( attempt <  3 )  //If we haven't already tried 3 times, then we'll try again.
            {
                return generateGameSessionCode(++attempt); //recursive call incrementing the number of attempts made.
            }
            else
            {
                throw new RuntimeException("Failed to generate a unique game session code three times."); //At 3 attempts, throw a runtime exception and give up :(
            }
        }

        return code.toString(); //We got a unique code!
    }

}
