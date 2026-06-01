package com.gamemaster.gmapp.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "rules_document_state")
public class RulesDocumentState {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private ComponentInstance componentInstance;

    @Column(name = "title")
    private String title;

    @Column(name = "content_markdown", columnDefinition = "text")
    private String contentMarkdown;

    @Column(name = "version")
    private int version;

    //Getters and Setters
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentMarkdown() {
        return contentMarkdown;
    }

    public void setContentMarkdown(String contentMarkdown) {
        this.contentMarkdown = contentMarkdown;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
