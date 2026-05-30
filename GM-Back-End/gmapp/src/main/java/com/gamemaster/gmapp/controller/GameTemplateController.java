package com.gamemaster.gmapp.controller;

import com.gamemaster.gmapp.GameTemplate;
import com.gamemaster.gmapp.service.GameTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameTemplateController {
    private final GameTemplateService gameTemplateService;

    /**
     * Pass in the service class through the constructor so that we can use it to interact with the database through the service layer.
     * @param gameTemplateService
     */
    public GameTemplateController(GameTemplateService gameTemplateService)
    {
        this.gameTemplateService = gameTemplateService;
    }

    /**
     * Simple method to get all game templates from the database.
     * @return
     */
    @GetMapping("/api/templates")
    public List<GameTemplate> getTemplates() {
        return gameTemplateService.getAllTemplates();
    }

    @PostMapping("/api/templates")
    public GameTemplate createTemplate(@RequestBody GameTemplate gameTemplate) {
        return gameTemplateService.saveTemplate(gameTemplate);
    }
}
