package com.gamemaster.gmapp.dto;

import java.util.UUID;

public class CreateRulesDocumentStateRequest {

    private UUID componentInstanceId;

    private String title;

    private String contentMarkdown;

    private int version;

    //Getters and Setters
    public UUID getComponentInstanceId() {
        return componentInstanceId;
    }

    public void setComponentInstanceId(UUID componentInstanceId) {
        this.componentInstanceId = componentInstanceId;
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
