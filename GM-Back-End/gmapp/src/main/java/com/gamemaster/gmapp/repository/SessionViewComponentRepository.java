package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.SessionViewComponent;
import com.gamemaster.gmapp.model.embeddable.SessionViewComponentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionViewComponentRepository extends JpaRepository<SessionViewComponent, SessionViewComponentId> {
    //intentionally left empty for now...
}
