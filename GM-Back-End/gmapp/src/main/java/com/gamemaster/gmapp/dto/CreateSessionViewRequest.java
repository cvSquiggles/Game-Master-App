package com.gamemaster.gmapp.dto;

import com.gamemaster.gmapp.model.GameSession;
import jakarta.persistence.*;

import java.util.UUID;

public class CreateSessionViewRequest {

    private UUID gameSessionId;

    private String name;

    private String icon;

    private int displayOrder;

    //Getters and Setters
    public UUID getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(UUID gameSessionId) {
        this.gameSessionId = gameSessionId;
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
