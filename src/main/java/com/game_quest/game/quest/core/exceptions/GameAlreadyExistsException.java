package com.game_quest.game.quest.core.exceptions;

public class GameAlreadyExistsException extends RuntimeException{
    public GameAlreadyExistsException(String message) {
        super(message);
    }
    public GameAlreadyExistsException() {
        super("Game already exists. Please, try another game...");
    }
}
