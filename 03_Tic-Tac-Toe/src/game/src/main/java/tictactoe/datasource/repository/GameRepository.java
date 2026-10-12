package tictactoe.datasource.repository;

import tictactoe.domain.model.Game;
import java.util.Optional;
import java.util.UUID;

public interface GameRepository {
    Game save(Game game);
    Optional<Game> findById(UUID id);
    boolean exists(UUID id);
}