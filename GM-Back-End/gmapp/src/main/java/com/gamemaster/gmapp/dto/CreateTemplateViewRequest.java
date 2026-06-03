package com.gamemaster.gmapp.dto;

import com.gamemaster.gmapp.model.GameTemplate;
import jakarta.persistence.*;

import java.util.UUID;

public class CreateTemplateViewRequest {

    private UUID id;

    private GameTemplate gameTemplate;

    private String name;

    private String icon; // Store the icon as a string (e.g., a path to the image)

    private int displayOrder; // The order in which the view should be displayed in the UI

    //Getters and setters

    public GameTemplate getGameTemplate() {
        return gameTemplate;
    }

    public void setGameTemplate(GameTemplate gameTemplate) {
        this.gameTemplate = gameTemplate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
