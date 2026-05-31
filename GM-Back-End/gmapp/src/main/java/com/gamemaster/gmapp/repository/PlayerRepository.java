package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
    //Left empty for now, findById doesn't even need to be setup explicitly as a derived query method, because it's already provided by JpaRepository.
}
