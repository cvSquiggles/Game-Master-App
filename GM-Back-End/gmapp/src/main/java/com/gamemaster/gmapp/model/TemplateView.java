package com.gamemaster.gmapp.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "template_view")
public class TemplateView {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "game_template")
    private GameTemplate gameTemplate;

    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    private String icon; // Store the icon as a string (e.g., a path to the image)

    @Column(name = "display_order")
    private int displayOrder; // The order in which the view should be displayed in the UI

    //Getters and setters
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
