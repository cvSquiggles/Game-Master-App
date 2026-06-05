package com.gamemaster.gmapp.model.embeddable;

import com.gamemaster.gmapp.model.TemplateViewComponent;
import jakarta.persistence.Embeddable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class TemplateViewComponentId {

    private UUID viewId;

    private UUID templateComponentId;

    //Apparently all @Embeddable classes require a default constructor explicitly defined according to the JPA specification.
    public TemplateViewComponentId(){}

    public TemplateViewComponentId(UUID viewId, UUID templateComponentId) {
        this.viewId = viewId;
        this.templateComponentId = templateComponentId;
    }

    //Getters and Setters
    public UUID getViewId() {
        return viewId;
    }

    public void setViewId(UUID viewId) {
        this.viewId = viewId;
    }

    public UUID getTemplateComponentId() {
        return templateComponentId;
    }

    public void setTemplateComponentId(UUID templateComponentId) {
        this.templateComponentId = templateComponentId;
    }

    //Override the equals and hashCode methods, defaults won't work for composite key class
    @Override
    public boolean equals(Object o)
    {

        if(this == o) {
            return true; //If it's literally the same object address, then yes, they're equal
        }
        else if ( o == null || getClass() != o.getClass()) {
            return false; //If it's null, or not the same class as TemplateViewComponentId, then no, they're not equal
        }

        /*Otherwise, do the proper comparison, but we cast Object o to a TemplateViewComponentId so we can explicitly
         /check equality on each field, just using this.equals doesn't work because that calls this method again! */
        TemplateViewComponentId obj = (TemplateViewComponentId) o;
        return (Objects.equals(this.getViewId(), obj.getViewId())
                && Objects.equals(this.getTemplateComponentId(), obj.getTemplateComponentId()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(viewId, templateComponentId);
    }
}
