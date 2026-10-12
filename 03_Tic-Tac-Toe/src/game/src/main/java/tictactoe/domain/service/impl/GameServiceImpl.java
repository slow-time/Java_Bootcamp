package tictactoe.domain.service.impl;

import tictactoe.domain.model.Game;
import tictactoe.domain.model.Field;
import tictactoe.domain.service.GameService;
import tictactoe.datasource.repository.GameRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createNewGame() {
        Game game = Game.createNew();
        return gameRepository.save(game);
    }

    @Override
    public Optional<Game> getGame(UUID id) {
        return gameRepository.findById(id);
    }

    @Override
    public Game makeMove(UUID gameId, int row, int col) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));

        Field field = game.getField();

        if (isGameOver(game)) {
            throw new IllegalStateException("Game is already over");
        }

        if (!field.isEmpty(row, col)) {
            throw new IllegalArgumentException("Cell is already occupied");
        }

        field.setCell(row, col, 1);

        if (!isGameOver(game)) {
            int[] bestMove = minimax(field, 2);
            if (bestMove[0] != -1) {
                field.setCell(bestMove[0], bestMove[1], 2);
            }
        }

        gameRepository.save(game);

        return game;
    }

    @Override
    public boolean isGameOver(Game game) {
        Field field = game.getField();
        return checkWinner(field, 1) ||
                checkWinner(field, 2) ||
                field.isFull();
    }

    @Override
    public int getWinner(Game game) {
        Field field = game.getField();

        if (checkWinner(field, 1)) return 1;
        if (checkWinner(field, 2)) return 2;
        if (!field.isFull()) return 3;

        return 0;
    }

    private boolean checkWinner(Field field, int player) {
        for (int i = 0; i < 3; i++) {
            if (field.getCell(i, 0) == player &&
                    field.getCell(i, 1) == player &&
                    field.getCell(i, 2) == player) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field.getCell(0, i) == player &&
                    field.getCell(1, i) == player &&
                    field.getCell(2, i) == player) {
                return true;
            }
        }

        if (field.getCell(0, 0) == player &&
                field.getCell(1, 1) == player &&
                field.getCell(2, 2) == player) {
            return true;
        }

        if (field.getCell(0, 2) == player &&
                field.getCell(1, 1) == player &&
                field.getCell(2, 0) == player) {
            return true;
        }

        return false;
    }

    private int[] minimax(Field field, int currentPlayer) {
        if (checkWinner(field, 2)) return new int[]{-1, -1, 10};
        if (checkWinner(field, 1)) return new int[]{-1, -1, -10};
        if (field.isFull()) return new int[]{-1, -1, 0};

        if (isFirstMove(field)) {
            return new int[]{1, 1, 0};
        }

        int bestScore = (currentPlayer == 2) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int[] bestMove = new int[]{-1, -1, bestScore};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.getCell(i, j) == 0) {
                    field.setCell(i, j, currentPlayer);
                    int[] result = minimax(field, (currentPlayer == 2) ? 1 : 2);
                    int currentScore = result[2];
                    field.setCell(i, j, 0);

                    if (currentPlayer == 2) {
                        if (currentScore > bestScore) {
                            bestScore = currentScore;
                            bestMove = new int[]{i, j, bestScore};
                        }
                    } else {
                        if (currentScore < bestScore) {
                            bestScore = currentScore;
                            bestMove = new int[]{i, j, bestScore};
                        }
                    }
                }
            }
        }
        return bestMove;
    }

    private boolean isFirstMove(Field field) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.getCell(i, j) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}