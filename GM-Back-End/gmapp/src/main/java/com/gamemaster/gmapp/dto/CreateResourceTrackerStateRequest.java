package com.gamemaster.gmapp.dto;

import com.gamemaster.gmapp.model.ComponentInstance;
import java.util.UUID;

public class CreateResourceTrackerStateRequest {


    private UUID componentInstanceId;

    private String resourceName;

    private String unitLabel;

    private double currentValue;

    private double maxValue;

    private double minValue;

    private double stepSize;

    public UUID getComponentInstanceId() {
        return componentInstanceId;
    }

    public void setComponentInstanceId(UUID componentInstanceId) {
        this.componentInstanceId = componentInstanceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getUnitLabel() {
        return unitLabel;
    }

    public void setUnitLabel(String unitLabel) {
        this.unitLabel = unitLabel;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getStepSize() {
        return stepSize;
    }

    public void setStepSize(double stepSize) {
        this.stepSize = stepSize;
    }
}
