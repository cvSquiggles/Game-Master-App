package com.gamemaster.gmapp.dto;

import com.gamemaster.gmapp.model.GameSession;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateGameSaveRequest {

    private UUID gameSessionId;

    private String saveType;

    private String stateBlob;

    private LocalDateTime createdAt;

    //Getters and Setters

    public UUID getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(UUID gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public String getSaveType() {
        return saveType;
    }

    public void setSaveType(String saveType) {
        this.saveType = saveType;
    }

    public String getStateBlob() {
        return stateBlob;
    }

    public void setStateBlob(String stateBlob) {
        this.stateBlob = stateBlob;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
