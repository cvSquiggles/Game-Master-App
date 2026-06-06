package com.gamemaster.gmapp.repository;

import com.gamemaster.gmapp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
    List<Player> findByGameSession_SessionCode(String gameSessionCode);
    //Left empty for now, findById doesn't even need to be setup explicitly as a derived query method, because it's already provided by JpaRepository.
}
