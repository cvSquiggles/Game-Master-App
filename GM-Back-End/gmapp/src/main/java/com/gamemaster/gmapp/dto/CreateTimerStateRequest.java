package com.gamemaster.gmapp.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateTimerStateRequest {

    private UUID componentInstanceId;

    private String mode; // "countdown" or "stopwatch"

    private int currentValueMs; // Store the current value in milliseconds

    private int bufferMs; // Store the buffer value in milliseconds

    private int minMs; // Store the minimum value in milliseconds

    private int maxMs; // Store the maximum value in milliseconds

    private boolean randomizeStart; // Whether to randomize the start value for countdown timers

    private String status; // "idle", "buffer", "running", "paused", "finished"

    private LocalDateTime lastTickAt; // Timestamp of the last tick, used for calculating elapsed time

    //Getters and setters


    public UUID getComponentInstanceId() {
        return componentInstanceId;
    }

    public void setComponentInstanceId(UUID componentInstanceId) {
        this.componentInstanceId = componentInstanceId;
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
