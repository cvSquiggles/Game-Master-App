package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.model.GameSave;
import com.gamemaster.gmapp.service.GameSaveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameSaveController {

    private GameSaveService gameSaveService;

    public GameSaveController(GameSaveService gameSaveService)
    {
        this.gameSaveService = gameSaveService;
    }

    //The main game save service method is used during Game Save attempts handled by the GameSesionController api calls. This controller may be used to pull up the list of saves for a given session to revert to, but for now it's just here.
    @GetMapping("/api/game-saves/")
    public List<GameSave> findAllGameSaves()
    {
        return gameSaveService.findAllGameSaves();
    }
}
