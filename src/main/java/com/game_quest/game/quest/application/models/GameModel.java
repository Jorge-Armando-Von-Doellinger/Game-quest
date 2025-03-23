package com.game_quest.game.quest.application.models;

import com.game_quest.game.quest.core.enums.GameStatus;
import lombok.Data;

@Data
public class GameModel {
    private String name;
    private GameStatus status;
}
