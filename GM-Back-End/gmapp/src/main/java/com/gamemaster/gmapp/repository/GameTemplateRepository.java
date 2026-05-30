package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.GameTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameTemplateRepository extends JpaRepository<GameTemplate, UUID> {
    //Empty for now? I guess extending JpaRepository gives us all the basic operations we need without any tweaks?
}
