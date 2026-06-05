package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.TemplateViewComponent;
import com.gamemaster.gmapp.model.embeddable.TemplateViewComponentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateViewComponentRepository extends JpaRepository<TemplateViewComponent, TemplateViewComponentId> {
    //Intentionally left empty for now, I don't think I have to do anything different here as a result of the non-standard primary ID field type, but we'll see *shrugs*
}
