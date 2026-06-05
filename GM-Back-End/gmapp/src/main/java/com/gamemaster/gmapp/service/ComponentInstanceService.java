package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.dto.CreateComponentInstanceRequest;
import com.gamemaster.gmapp.model.ComponentInstance;
import com.gamemaster.gmapp.model.GameSession;
import com.gamemaster.gmapp.model.Player;
import com.gamemaster.gmapp.model.TemplateComponent;
import com.gamemaster.gmapp.repository.ComponentInstanceRepository;
import org.hibernate.sql.Template;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing ComponentInstance entities.
 * Provides business logic and interacts with the ComponentInstanceRepository.
 */
@Service
public class ComponentInstanceService {

    private ComponentInstanceRepository componentInstanceRepository; // Repository for accessing ComponentInstance
    private GameSessionService gameSessionService; // Service for accessing GameSession entities, needed to associate a ComponentInstance with a GameSession when creating a new instance.
    private PlayerService playerService; // Service for accessing Player entities, needed to associate a ComponentInstance with an owner Player when creating a new instance.
    private TemplateComponentService templateComponentService;

    public ComponentInstanceService(ComponentInstanceRepository componentInstanceRepository,
                                    GameSessionService gameSessionService,
                                    PlayerService playerService,
                                    TemplateComponentService templateComponentService)
    {
        this.componentInstanceRepository = componentInstanceRepository;
        this.gameSessionService = gameSessionService;
        this.playerService = playerService;
        this.templateComponentService = templateComponentService;
    }

    // Method to retrieve all ComponentInstance entities from the database
    public List<ComponentInstance> getAllComponentInstances() {
        return componentInstanceRepository.findAll();
    }

    public Optional<ComponentInstance> findById(UUID id) {
        return componentInstanceRepository.findById(id);
    }

    public ComponentInstance saveComponentInstance(CreateComponentInstanceRequest request) {

        GameSession gameSession = gameSessionService.findById(request.getGameSessionId()).orElseThrow(()-> new RuntimeException("Game session not found for id: " + request.getGameSessionId()));
        /*This field is also nullable like the one below, so follow the Optional.ofNullable handling to allow for component instance objects without a template component.
         *Additional learning note, without "orElse(null)", flatMap returns an Optional wrapped object that could contain anything or nothing, but we need a TemplateComponent here.
         * the "orElse(null)" unwraps the optional, and either uses what's in it, or gives us a null, which the JPA can handle since the field is nullable. */
        TemplateComponent templateComponent = Optional.ofNullable(request.getTemplateComponentId()).flatMap(templateComponentService::findById).orElse(null);

        /*Owner player is nullable, so we need to handle the case where the request does not include and ownerPlayerId.
        * Optional supports this, and we use flatMap instead of Map, because it automatically unwraps the result of the function,
        * so we don't just end up with an Optional<Optional<Player>>. No RuntimeException since it's okay to be null. SEE BETTER EXPLANATION IN COMMENT ABOVE :) */
        Player ownerPlayer = Optional.ofNullable(request.getOwnerPlayerId()).flatMap(playerService::findById).orElse(null);

        ComponentInstance componentInstance = new ComponentInstance();
        componentInstance.setGameSession(gameSession);
        componentInstance.setOwnerPlayer(ownerPlayer);
        componentInstance.setTemplateComponent(templateComponent); //updated to tie to actual template_component entity
        componentInstance.setComponentType(request.getComponentType());
        componentInstance.setLabel(request.getLabel());
        componentInstance.setConfig(request.getConfig());
        componentInstance.setDisplayOrder(request.getDisplayOrder());


        return componentInstanceRepository.save(componentInstance);
    }

}
