package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.TemplateComponent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemplateComponentRepository extends JpaRepository<TemplateComponent, UUID> {
    //Intentionally left empty for now...
}
