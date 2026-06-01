package com.gamemaster.gmapp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "timer_state")
public class TimerState {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private ComponentInstance componentInstance;

    @Column(name = "mode")
    private String mode; // "countdown" or "stopwatch"

    @Column(name = "current_value_ms")
    private int currentValueMs; // Store the current value in milliseconds

    @Column(name = "buffer_ms")
    private int bufferMs; // Store the buffer value in milliseconds

    @Column(name = "min_ms")
    private int minMs; // Store the minimum value in milliseconds

    @Column(name = "max_ms")
    private int maxMs; // Store the maximum value in milliseconds

    @Column(name = "randomize_start")
    private boolean randomizeStart; // Whether to randomize the start value for countdown timers

    @Column(name = "status")
    private String status; // "idle", "buffer", "running", "paused", "finished"

    @Column(name = "last_tick_at")
    private LocalDateTime lastTickAt; // Timestamp of the last tick, used for calculating elapsed time

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getCurrentValueMs() {
        return currentValueMs;
    }

    public void setCurrentValueMs(int currentValueMs) {
        this.currentValueMs = currentValueMs;
    }

    public int getBufferMs() {
        return bufferMs;
    }

    public void setBufferMs(int bufferMs) {
        this.bufferMs = bufferMs;
    }

    public int getMinMs() {
        return minMs;
    }

    public void setMinMs(int minMs) {
        this.minMs = minMs;
    }

    public int getMaxMs() {
        return maxMs;
    }

    public void setMaxMs(int maxMs) {
        this.maxMs = maxMs;
    }

    public boolean getRandomizeStart() {
        return randomizeStart;
    }

    public void setRandomizeStart(boolean randomizeStart) {
        this.randomizeStart = randomizeStart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastTickAt() {
        return lastTickAt;
    }

    public void setLastTickAt(LocalDateTime lastTickAt) {
        this.lastTickAt = lastTickAt;
    }
}
