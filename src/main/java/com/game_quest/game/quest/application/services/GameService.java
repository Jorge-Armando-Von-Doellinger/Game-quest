package com.game_quest.game.quest.application.services;

import com.game_quest.game.quest.core.entity.Game;
import com.game_quest.game.quest.core.enums.GameStatus;
import com.game_quest.game.quest.core.exceptions.GameAlreadyExistsException;
import com.game_quest.game.quest.core.exceptions.GameIdNotFoundedException;
import com.game_quest.game.quest.core.interfaces.IGameRepository;
import com.game_quest.game.quest.core.interfaces.IGameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService implements IGameService {
    private final IGameRepository _repository;

    public GameService(IGameRepository repository){
        _repository = repository;
    }

    @Override
    public Game getGameById(Long id) {
        return _repository.findById(id).orElseThrow(GameIdNotFoundedException::new);
    }

    @Override
    public List<Game> getGames() {
        return _repository.findAll();
    }

    @Override
    @Transactional
    public List<Game> getGamesByStatus(GameStatus status) {
        return _repository.findByStatus(status);
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        var gameInDatabase = _repository.findByName(game.getName());
        if(gameInDatabase != null) { throw new GameAlreadyExistsException(); }
        return _repository.save(game);
    }

    @Override
    @Transactional
    public void setStatusById(Long id, GameStatus status) {
        var game = _repository.findById(id).orElseThrow(GameIdNotFoundedException::new);
        game.setStatus(status);
        _repository.save(game);
    }

    @Override
    @Transactional
    public void clear() {
        _repository.deleteAll();
    }

}
