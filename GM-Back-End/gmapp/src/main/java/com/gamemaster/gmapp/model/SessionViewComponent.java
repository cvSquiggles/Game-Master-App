package com.gamemaster.gmapp.model;

import com.gamemaster.gmapp.model.embeddable.SessionViewComponentId;
import jakarta.persistence.*;

@Entity
@Table(name = "session_view_component")
public class SessionViewComponent {

    @EmbeddedId
    private SessionViewComponentId sessionViewComponentId;

    @MapsId("componentInstanceId")
    @ManyToOne
    @JoinColumn(name = "component_id")
    private ComponentInstance componentInstance;

    @MapsId("viewId")
    @ManyToOne
    @JoinColumn(name = "view_id")
    private SessionView sessionView;

    @Column(name = "position")
    private int position;

    public SessionViewComponentId getSessionViewComponentId() {
        return sessionViewComponentId;
    }

    public void setSessionViewComponentId(SessionViewComponentId sessionViewComponentId) {
        this.sessionViewComponentId = sessionViewComponentId;
    }

    public ComponentInstance getComponentInstance() {
        return componentInstance;
    }

    public void setComponentInstance(ComponentInstance componentInstance) {
        this.componentInstance = componentInstance;
    }

    public SessionView getSessionView() {
        return sessionView;
    }

    public void setSessionView(SessionView sessionView) {
        this.sessionView = sessionView;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
