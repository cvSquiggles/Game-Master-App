package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.RulesDocumentState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RulesDocumentStateRepository extends JpaRepository<RulesDocumentState, UUID> {
    //Intentionally left empty for now...
}
