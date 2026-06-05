package com.gamemaster.gmapp.model.embeddable;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class SessionViewComponentId {

    private UUID viewId;

    private UUID componentInstanceId;

    //Empty constructor included for JPA to handle this correctly!
    public SessionViewComponentId() {};

    public SessionViewComponentId(UUID viewId, UUID componentId) {
        this.componentInstanceId = componentId;
        this.viewId = viewId;
    }

    public UUID getComponentInstanceId() {
        return componentInstanceId;
    }

    public void setComponentInstanceId(UUID componentId) {
        this.componentInstanceId = componentId;
    }

    public UUID getViewId() {
        return viewId;
    }

    public void setViewId(UUID viewId) {
        this.viewId = viewId;
    }

    //Overriding equals() and hashCode() for JPA repo interactions to run successfully
    @Override
    public boolean equals(Object o ) {
        if( o == this )
        {
            return true; //If it's literally the same object address, then yes, they're equal
        }
        else if( o == null || o.getClass() != this.getClass())
        {
            return false; //If it's null, or not the same class as TemplateViewComponentId, then no, they're not equal
        }

        SessionViewComponentId obj = (SessionViewComponentId) o;
        return (Objects.equals(this.getViewId(), obj.getViewId())
                && Objects.equals(this.getComponentInstanceId(), obj.getComponentInstanceId()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.componentInstanceId, this.viewId);
    }
}
