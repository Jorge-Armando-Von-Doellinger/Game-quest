package com.game_quest.game.quest.api.controllers;


import com.game_quest.game.quest.application.mapper.GameMapper;
import com.game_quest.game.quest.application.models.GameModel;
import com.game_quest.game.quest.core.entity.Game;
import com.game_quest.game.quest.core.enums.GameStatus;
import com.game_quest.game.quest.core.exceptions.GameIdNotFoundedException;
import com.game_quest.game.quest.core.interfaces.IGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("game")
public class GameController {
    private final IGameService _service;
    private final GameMapper _mapper;
    public GameController(IGameService service, GameMapper mapper) {
        _service = service;
        _mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getGames() {
        return ResponseEntity.ok(_service.getGames());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        return ResponseEntity.ok(_service.getGameById(id));
    }
    @GetMapping("dropped-games")
    public ResponseEntity<List<Game>> getDroppedGames() {
        return ResponseEntity.ok(_service.getGamesByStatus(GameStatus.Dropped));
    }
    @GetMapping("played-games")
    public ResponseEntity<List<Game>> getPlayedGames() {
        return ResponseEntity.ok(_service.getGamesByStatus(GameStatus.Played));
    }
    @GetMapping("playing-games")
    public ResponseEntity<List<Game>> getPlayingGames() {
        return ResponseEntity.ok(_service.getGamesByStatus(GameStatus.Playing));
    }
    @GetMapping("postponed-games")
    public ResponseEntity<List<Game>> getPostponedGames() {
        return ResponseEntity.ok(_service.getGamesByStatus(GameStatus.Postponed));
    }
    @GetMapping("games-to-play")
    public ResponseEntity<List<Game>> getGamesToPlay() {
        return ResponseEntity.ok(_service.getGamesByStatus(GameStatus.ToPlay));
    }


    @PostMapping
    public ResponseEntity<Game> addGame(GameModel model) {
        var game = _service.addGame(_mapper.mapToGameEntity(model));
        return ResponseEntity.ok(game);
    }

    @PutMapping("/set/played-game/{id}")
    public ResponseEntity<Void> setPlayedGame(@PathVariable Long id) {
        _service.setStatusById(id, GameStatus.Played);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/set/playing-game/{id}")
    public ResponseEntity<Void> setPlayingGame(@PathVariable Long id) {
        _service.setStatusById(id, GameStatus.Playing);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/set/postponed-game/{id}")
    public ResponseEntity<Void> setPostponedGame(@PathVariable Long id) {
        _service.setStatusById(id, GameStatus.Postponed);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/set/to-play-game/{id}")
    public ResponseEntity<Void> setGameToPlay(@PathVariable Long id) {
        _service.setStatusById(id, GameStatus.ToPlay);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/set/abandoned-game/{id}")
    public ResponseEntity<Void> setAbandonedGame(@PathVariable Long id) {
        System.out.println(id.toString() + " AKI CARAIIOOOOO");
        _service.setStatusById(id, GameStatus.Dropped);
        return ResponseEntity.noContent().build();
    }
}
