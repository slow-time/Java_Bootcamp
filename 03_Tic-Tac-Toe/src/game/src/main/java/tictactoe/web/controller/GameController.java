package tictactoe.web.controller;

import org.springframework.web.bind.annotation.*;
import tictactoe.domain.model.Game;
import tictactoe.domain.model.Field;
import tictactoe.domain.service.GameService;
import tictactoe.web.exception.InvalidGameException;
import tictactoe.web.mapper.WebMapper;
import tictactoe.web.model.GameDto;
import java.util.*;

@RestController
public class GameController {

    private final GameService gameService;
    private final WebMapper webMapper;

    public GameController(GameService gameService, WebMapper webMapper) {
        this.gameService = gameService;
        this.webMapper = webMapper;
    }

    @PostMapping("/game")
    public GameDto createGame() {
        Game game = gameService.createNewGame();
        return webMapper.toDto(game);
    }

    @GetMapping("/game/{id}")
    public GameDto getGame(@PathVariable UUID id) {
        Game game = gameService.getGame(id)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));
        return webMapper.toDto(game);
    }

    @PostMapping("/game/{id}")
    public GameDto makeMove(
            @PathVariable UUID id,
            @RequestBody GameDto gameDto) {

        if (!id.equals(gameDto.getId())) {
            throw new InvalidGameException("Game ID in path and body do not match");
        }

        Game currentGame = gameService.getGame(id)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));

        Game gameFromClient = webMapper.toDomain(gameDto);

        if (!isValidMove(gameFromClient)) {
            throw new InvalidGameException("Invalid move: you can only change one empty cell to 1");
        }

        int[] move = findPlayerMove(gameFromClient);
        int row = move[0];
        int col = move[1];

        Game updatedGame = gameService.makeMove(id, row, col);

        return webMapper.toDto(updatedGame);
    }

    private boolean isValidMove(Game game) {
        Optional<Game> existingGameOpt = gameService.getGame(game.getId());
        if (existingGameOpt.isEmpty()) {
            return false;
        }

        Field existingField = existingGameOpt.get().getField();
        Field newField = game.getField();

        int changes = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int oldVal = existingField.getCell(i, j);
                int newVal = newField.getCell(i, j);

                if (oldVal != 0 && oldVal != newVal) {
                    return false;
                }
                if (oldVal == 0 && newVal != 0) {
                    changes++;
                    if (newVal != 1) {
                        return false;
                    }
                }
            }
        }
        return changes == 1;
    }

    private int[] findPlayerMove(Game game) {
        Optional<Game> existingGameOpt = gameService.getGame(game.getId());
        if (existingGameOpt.isEmpty()) {
            return new int[]{-1, -1};
        }

        Field existingField = existingGameOpt.get().getField();
        Field newField = game.getField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (existingField.getCell(i, j) == 0 && newField.getCell(i, j) != 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}