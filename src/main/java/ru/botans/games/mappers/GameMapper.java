package ru.botans.games.mappers;

import org.springframework.stereotype.Component;
import ru.botans.games.dto.Game;
import ru.botans.games.models.GameModel;

@Component
public class GameMapper {

    public Game fromGameModelToGame(final GameModel model) {
        Game game = new Game();
        game.setName(model.getName());
        game.setDescription(model.getDescription());
        return game;
    }

    public GameModel fromGameToGameModel(final Game game) {
        GameModel model = new GameModel();
        model.setId(game.getId());
        model.setName(game.getName());
        model.setDescription(game.getDescription());
        return model;
    }
}
