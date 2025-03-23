package com.game_quest.game.quest.application.mapper;

import com.game_quest.game.quest.application.models.GameModel;
import com.game_quest.game.quest.core.entity.Game;
import org.springframework.stereotype.Service;

@Service
public class GameMapper {
    public Game mapToGameEntity(GameModel model) {
        var game = new Game();
        game.setStatus(model.getStatus());
        game.setName(model.getName());
        return game;
    }
}
