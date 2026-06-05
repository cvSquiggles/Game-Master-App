package com.gamemaster.gmapp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

/*This Entity doesn't need a DTO to handle the GameSession association, because we'll only ever attempt to save after having
 already pulled the GameSession to check the active_session_token, so we can just pass that in with the save request*/
@Entity
@Table(name = "game_save")
public class GameSave {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private GameSession gameSession;

    @Column(name = "save_type")
    private String saveType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "state_blob", columnDefinition = "jsonb")
    private String stateBlob;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    //Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GameSession getGameSession() {
        return gameSession;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
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
