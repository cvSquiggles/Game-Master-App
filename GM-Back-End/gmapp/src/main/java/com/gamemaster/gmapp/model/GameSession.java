package com.gamemaster.gmapp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This will contain all the information within a game session, from the players, to the state of all the components,
 * as well as a unique game session code that can be used to resume a previous game session.
 */
@Entity
@Table(name = "game_session")
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //foreign key relation to the game template that this session is using.
    @ManyToOne
    @JoinColumn(name = "template_id", nullable = true)
    private GameTemplate template;

    @Column(name = "name")
    private String name;

    @Column(name = "session_code")
    private String sessionCode;

    @Column(name = "status")
    private String status;

    @Column(name = "active_session_token")
    private UUID activeSessionToken;

    @UpdateTimestamp
    @Column(name = "last_active_at")
    private LocalDateTime lastActiveAt;

    @CreationTimestamp
    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    //Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GameTemplate getTemplate() {
        return template;
    }

    public void setTemplate(GameTemplate template) {
        this.template = template;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionCode() {
        return sessionCode;
    }

    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getActiveSessionToken() {
        return activeSessionToken;
    }

    public void setActiveSessionToken(UUID activeSessionToken) {
        this.activeSessionToken = activeSessionToken;
    }

    public LocalDateTime getLastActiveAt() {
        return lastActiveAt;
    }

    public void setLastActiveAt(LocalDateTime lastActiveAt) {
        this.lastActiveAt = lastActiveAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }





}
