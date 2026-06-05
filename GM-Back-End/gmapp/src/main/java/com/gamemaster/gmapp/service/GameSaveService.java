package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateGameSaveRequest;
import com.gamemaster.gmapp.model.GameSave;
import com.gamemaster.gmapp.model.GameSession;
import com.gamemaster.gmapp.repository.GameSaveRepository;
import org.springframework.stereotype.Service;

@Service
public class GameSaveService {

    private GameSaveRepository gameSaveRepository;
    private GameSessionService gameSessionService;

    public GameSaveService(GameSaveRepository gameSaveRepository,
                           GameSessionService gameSessionService)
    {
        this.gameSaveRepository = gameSaveRepository;
        this.gameSessionService = gameSessionService;
    }

    public GameSave createGameSave(CreateGameSaveRequest request)
    {
        GameSession gameSession = gameSessionService.findById(request.getGameSessionId()).orElseThrow(() -> new RuntimeException("No game session found with id: " + request.getGameSessionId() + " when attempting to save game state."));

        GameSave gameSave = new GameSave();
        gameSave.setGameSession(gameSession);
        gameSave.setSaveType(request.getSaveType());
        gameSave.setStateBlob(request.getStateBlob());
        //I don't need to explicilty set the created_at value here because the database is set to default it to the time of record creation

        return gameSaveRepository.save(gameSave);

    }



}
