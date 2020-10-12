package ru.botans.games.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.botans.games.dto.Game;
import ru.botans.games.mappers.GameMapper;
import ru.botans.games.models.GameModel;
import ru.botans.games.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/games")
public class GamesController {

    GameRepository repository;

    GameMapper mapper;

    @Autowired
    public GamesController(
            GameRepository repository,
            GameMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public String index(Model model) {
        log.info("Get request all games");
        List<Game> allGames = repository.findAll();
        log.info("Found games {}", allGames);
        List<GameModel> games = new ArrayList<>();
        for (Game game : allGames) {
            games.add(mapper.fromGameToGameModel(game));
        }
        model.addAttribute("games", games);
        return "games/index";
    }

    @GetMapping("/{name}")
    public String show(@PathVariable("name") String name, Model model) {
        log.info("Get request game {}", name);
        Game game = repository.findByName(name);
        log.info("Found the game {}", game);
        model.addAttribute("game", mapper.fromGameToGameModel(game));
        return "games/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("game") GameModel gameModel) {
        log.info("Adding new game");
        return "games/new";
    }

    @PostMapping
    public String create(@ModelAttribute("game") GameModel gameModel) {
        log.info("Saving new game {}", gameModel);
        repository.save(mapper.fromGameModelToGame(gameModel));
        log.info("Successfully saved");
        return "redirect:/games";
    }
}
