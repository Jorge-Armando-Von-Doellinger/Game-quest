package com.game_quest.game.quest.api.handler;

import com.game_quest.game.quest.core.exceptions.GameAlreadyExistsException;
import com.game_quest.game.quest.core.exceptions.GameIdNotFoundedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(GameIdNotFoundedException.class)
    private ResponseEntity<String> gameIdNotFoundedException(GameIdNotFoundedException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(GameAlreadyExistsException.class)
    private ResponseEntity<String> gameAlreadyExistsException(GameAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Throwable.class)
    private ResponseEntity<String> unexpectedException(Throwable ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Unexpected error, please, see logs.. \n Error: " + ex.getMessage());
    }
}
