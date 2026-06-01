package com.gamemaster.gmapp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "score_tracker_state")
public class ScoreTrackerState {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private ComponentInstance componentInstance;

    @Column(name = "current_score")
    private double currentScore;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "increment_presets", columnDefinition = "jsonb")
    private String incrementPresets; // Store as JSON string

    @Column(name = "allow_negative")
    private boolean allowNegative;

    //Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ComponentInstance getComponentInstance() {
        return componentInstance;
    }

    public void setComponentInstance(ComponentInstance componentInstance) {
        this.componentInstance = componentInstance;
    }

    public double getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(double currentScore) {
        this.currentScore = currentScore;
    }

    public String getIncrementPresets() {
        return incrementPresets;
    }

    public void setIncrementPresets(String incrementPresets) {
        this.incrementPresets = incrementPresets;
    }

    public boolean getAllowNegative() {
        return allowNegative;
    }

    public void setAllowNegative(boolean allowNegative) {
        this.allowNegative = allowNegative;
    }
}
