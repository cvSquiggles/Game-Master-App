package com.gamemaster.gmapp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "component_instance")
public class ComponentInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private GameSession gameSession;

    @ManyToOne
    @JoinColumn(name = "owner_player_id")
    private Player ownerPlayer;

    @Column(name = "template_component_id")
    private UUID templateComponentId;

    @Column(name = "component_type")
    private String componentType;

    @Column(name = "label")
    private String label;

    @JdbcTypeCode(SqlTypes.JSON) //Included this to tell Hibernate to use the correct type for the JSONB column when communicating with the database.
    @Column(name = "config", columnDefinition = "jsonb")
    private String config;

    @Column(name = "display_order")
    private int displayOrder;

    // Getters and setters
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

    public Player getOwnerPlayer() {
        return ownerPlayer;
    }

    public void setOwnerPlayer(Player ownerPlayer) {
        this.ownerPlayer = ownerPlayer;
    }

    public UUID getTemplateComponentId() {
        return templateComponentId;
    }

    public void setTemplateComponentId(UUID templateComponentId) {
        this.templateComponentId = templateComponentId;
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

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
