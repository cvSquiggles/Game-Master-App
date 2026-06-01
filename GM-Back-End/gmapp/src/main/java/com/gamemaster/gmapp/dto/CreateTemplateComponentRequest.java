package com.gamemaster.gmapp.dto;

import com.gamemaster.gmapp.model.GameTemplate;
import java.util.UUID;

public class CreateTemplateComponentRequest {

    private UUID gameTemplateId;

    private String componentType; // e.g., "timer", "initiative_tracker", etc.

    private String label; // A user-friendly label for the component, e.g., "Main Timer", "Combat Tracker", etc.

    private String defaultConfig; // Store the default configuration for the component as a JSON string

    private int displayOrder; // The order in which the component should be displayed in the UI

    // Getters and setters
    public UUID getGameTemplateId() {
        return gameTemplateId;
    }

    public void setGameTemplateId(UUID gameTemplateId) {
        this.gameTemplateId = gameTemplateId;
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

    public String getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(String defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
