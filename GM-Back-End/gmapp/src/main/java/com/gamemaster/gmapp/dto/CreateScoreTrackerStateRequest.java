package com.gamemaster.gmapp.dto;

import com.gamemaster.gmapp.model.ComponentInstance;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

public class CreateScoreTrackerStateRequest {

        private UUID componentInstanceId;

        private double currentScore;

        private String incrementPresets; // Store as JSON string

        private boolean allowNegative;

        //Getters and setters

        public UUID getComponentInstanceId() {
            return componentInstanceId;
        }

        public void setComponentInstanceId(UUID componentInstanceId) {
            this.componentInstanceId = componentInstanceId;
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
