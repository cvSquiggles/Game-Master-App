package com.gamemaster.gmapp.dto;

import java.util.UUID;

public class CreateTemplateViewComponentRequest {

    private UUID templateViewId;

    private UUID templateComponentId;

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public UUID getTemplateComponentId() {
        return templateComponentId;
    }

    public void setTemplateComponentId(UUID templateComponentId) {
        this.templateComponentId = templateComponentId;
    }

    public UUID getTemplateViewId() {
        return templateViewId;
    }

    public void setTemplateViewId(UUID templateViewId) {
        this.templateViewId = templateViewId;
    }

}
