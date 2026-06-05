package com.gamemaster.gmapp.model;

import com.gamemaster.gmapp.model.embeddable.TemplateViewComponentId;
import jakarta.persistence.*;

@Entity
@Table(name = "template_view_component")
public class TemplateViewComponent {

    //id comprised of our composite key class
    @EmbeddedId
    private TemplateViewComponentId templateViewComponentId;

    //MapsId maps to the composite id class field names, JoinColumn still assumes id in the "parent" table.
    @MapsId("viewId")
    @ManyToOne
    @JoinColumn(name = "view_id")
    private TemplateView templateView;

    @MapsId("templateComponentId")
    @ManyToOne
    @JoinColumn(name = "template_compoonent_id")
    private TemplateComponent templateComponent;

    @Column(name = "position")
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public TemplateComponent getTemplateComponent() {
        return templateComponent;
    }

    public void setTemplateComponent(TemplateComponent templateComponent) {
        this.templateComponent = templateComponent;
    }

    public TemplateView getTemplateView() {
        return templateView;
    }

    public void setTemplateView(TemplateView templateView) {
        this.templateView = templateView;
    }

    public TemplateViewComponentId getTemplateViewComponentId() {
        return templateViewComponentId;
    }

    public void setTemplateViewComponentId(TemplateViewComponentId templateViewComponentId) {
        this.templateViewComponentId = templateViewComponentId;
    }
}
