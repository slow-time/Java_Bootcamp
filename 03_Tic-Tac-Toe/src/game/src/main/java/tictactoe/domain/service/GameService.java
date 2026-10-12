package tictactoe.domain.service;

import tictactoe.domain.model.Game;
import java.util.Optional;
import java.util.UUID;

public interface GameService {

    Game createNewGame();

    Optional<Game> getGame(UUID id);

    Game makeMove(UUID gameId, int row, int col);

    boolean isGameOver(Game game);

    int getWinner(Game game);
}