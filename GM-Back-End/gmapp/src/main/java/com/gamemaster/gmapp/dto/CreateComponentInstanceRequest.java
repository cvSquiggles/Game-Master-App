package com.gamemaster.gmapp.dto;

import java.util.UUID;

// DTO for creating a new component instance in a game session. This will be used in the API request body when creating a new component instance.
// Needed since the non-DTO entity contains references to the GameSession and Player entities (handles UUID look-up)
public class CreateComponentInstanceRequest {

    private UUID gameSessionId;

    private UUID ownerPlayerId;

    private UUID templateComponentId;

    private String componentType;

    private String label;

    private String config;

    private int displayOrder;

    // Getters and setters

    public UUID getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(UUID gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public UUID getOwnerPlayerId() {
        return ownerPlayerId;
    }

    public void setOwnerPlayerId(UUID ownerPlayerId) {
        this.ownerPlayerId = ownerPlayerId;
    }

    public UUID getTemplateComponentId() {
        return templateComponentId;
    }

    public void setTemplateComponentId(UUID templateComponentId) {
        this.templateComponentId = templateComponentId;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
