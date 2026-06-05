package com.gamemaster.gmapp.dto;

import com.gamemaster.gmapp.model.TemplateComponent;
import com.gamemaster.gmapp.model.TemplateView;
import com.gamemaster.gmapp.model.embeddable.TemplateViewComponentId;
import jakarta.persistence.*;

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

    public UUID getTemplateView() {
        return templateViewId;
    }

    public void setTemplateView(UUID templateViewId) {
        this.templateViewId = templateViewId;
    }

}
