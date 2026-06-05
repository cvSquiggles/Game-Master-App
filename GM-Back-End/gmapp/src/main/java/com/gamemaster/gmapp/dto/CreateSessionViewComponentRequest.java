package com.gamemaster.gmapp.dto;

import java.util.UUID;

public class CreateSessionViewComponentRequest {

    private UUID componentInstanceId;

    private UUID sessionViewId;

    private int position;

    public UUID getComponentInstanceId() {
        return componentInstanceId;
    }

    public void setComponentInstanceId(UUID componentInstanceId) {
        this.componentInstanceId = componentInstanceId;
    }

    public UUID getSessionViewId() {
        return sessionViewId;
    }

    public void setSessionViewId(UUID sessionViewId) {
        this.sessionViewId = sessionViewId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
