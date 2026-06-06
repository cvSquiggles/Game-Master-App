package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.SaveGameSessionRequest;
import com.gamemaster.gmapp.model.GameSave;
import com.gamemaster.gmapp.model.GameSession;
import com.gamemaster.gmapp.repository.GameSaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameSaveService {

    private GameSaveRepository gameSaveRepository;

    public List<GameSave> findByGameSession_SessionCode(String gameSessionCode) {
        return gameSaveRepository.findByGameSession_SessionCode(gameSessionCode);
    }

    public enum SaveType {
        MANUAL("Manual"),
        AUTO("Auto");

        private final String saveType;

        SaveType(String saveType)
        {
            this.saveType = saveType;
        }

        public String getSaveType() {
            return this.saveType;
        }
    }

    public GameSaveService(GameSaveRepository gameSaveRepository)
    {
        this.gameSaveRepository = gameSaveRepository;
    }

    public List<GameSave> findAllGameSaves()
    {
        return gameSaveRepository.findAll();
    }

    public List<GameSave> findByGameSession_Id(UUID id)
    {
        return gameSaveRepository.findByGameSession_Id(id);
    }

    public GameSave createGameSave(GameSession gameSession, SaveGameSessionRequest request, String saveType)
    {
        GameSave gameSave = new GameSave();
        gameSave.setGameSession(gameSession);
        gameSave.setSaveType(saveType);
        gameSave.setStateBlob(request.getStateBlob());
        //I don't need to explicilty set the created_at value here because the database is set to default it to the time of record creation

        return gameSaveRepository.save(gameSave);

    }



}
