package com.game_quest.game.quest.core.exceptions;

public class GameIdNotFoundedException extends RuntimeException {
    public GameIdNotFoundedException(String message) {
        super(message);
    }
    public GameIdNotFoundedException() {
        super("Game id isn't found. Please, try again with another id!");
    }
}
