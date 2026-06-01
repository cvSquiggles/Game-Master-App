package com.gamemaster.gmapp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "template_component")
public class TemplateComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private GameTemplate gameTemplate;

    @Column(name = "component_type")
    private String componentType; // e.g., "timer", "initiative_tracker", etc.

    @Column(name = "label")
    private String label; // A user-friendly label for the component, e.g., "Main Timer", "Combat Tracker", etc.

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "default_config", columnDefinition = "jsonb")
    private String defaultConfig; // Store the default configuration for the component as a JSON string

    @Column(name = "display_order")
    private int displayOrder; // The order in which the component should be displayed in the UI

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GameTemplate getGameTemplate() {
        return gameTemplate;
    }

    public void setGameTemplate(GameTemplate gameTemplate) {
        this.gameTemplate = gameTemplate;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(String defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
