package com.game_quest.game.quest.core.interfaces;

import com.game_quest.game.quest.application.services.GameService;
import com.game_quest.game.quest.core.entity.Game;
import com.game_quest.game.quest.core.enums.GameStatus;
import com.game_quest.game.quest.core.exceptions.GameIdNotFoundedException;

import java.util.List;

public interface IGameService {
    Game getGameById(Long id);
    List<Game> getGames();
    List<Game> getGamesByStatus(GameStatus status);

    Game addGame(Game game);
    void setStatusById(Long id, GameStatus status);
    void clear();
}
