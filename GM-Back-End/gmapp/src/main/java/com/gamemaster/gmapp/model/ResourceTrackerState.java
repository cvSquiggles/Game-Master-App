package com.gamemaster.gmapp.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "resource_tracker_state")
public class ResourceTrackerState {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private ComponentInstance componentInstance;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "unit_label")
    private String unitLabel;

    @Column(name = "current_value")
    private double currentValue;

    @Column(name = "max_value")
    private double maxValue;

    @Column(name = "min_value")
    private double minValue;

    @Column(name = "step_size")
    private double stepSize;

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
