package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.TemplateView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemplateViewRepository extends JpaRepository<TemplateView, UUID> {
    //Intentionally left empty for now...
}
