package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.model.GameTemplate;
import com.gamemaster.gmapp.repository.GameTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameTemplateService {

    private final GameTemplateRepository gameTemplateRepository;

    /**
     * Pass in the repository class through the constructor, so that we can use it to interact with the database.
     * @param gameTemplateRepository
     */
    public GameTemplateService(GameTemplateRepository gameTemplateRepository) {
        this.gameTemplateRepository = gameTemplateRepository;
    }

    /**
     * Simple method to get all game templates from the database.
     * @return
     */
    public List<GameTemplate> getAllTemplates() {
        return gameTemplateRepository.findAll();
    }

    /**
     * Simple method to save a game template to the database.
     * @param gameTemplate
     * @return
     */
    public GameTemplate saveTemplate(GameTemplate gameTemplate)
    {
        return gameTemplateRepository.save(gameTemplate);
    }

    public Optional<GameTemplate> findById(UUID gameTemplateId) {
        return gameTemplateRepository.findById(gameTemplateId);
    }
}
