package com.game_quest.game.quest.core.interfaces;

import com.game_quest.game.quest.core.entity.Game;
import com.game_quest.game.quest.core.enums.GameStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// o jpa ja coloca funcionalidades automaticas, sem necessidade de implementacao
@Repository
public interface IGameRepository extends JpaRepository<Game, Long> {
    List<Game> findByStatus(GameStatus status);
    Game findByName(String name);
}
