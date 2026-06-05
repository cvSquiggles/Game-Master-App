package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.SessionView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionViewRepository extends JpaRepository<SessionView, UUID> {
    //Intentionally left empty for now...
}
