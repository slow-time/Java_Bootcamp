package tictactoe.datasource.storage;

import tictactoe.datasource.model.GameEntity;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GameStorage {
    private final Map<UUID, GameEntity> games = new ConcurrentHashMap<>();

    public void save(GameEntity game) {
        games.put(game.getId(), game);
    }

    public GameEntity findById(UUID id) {
        return games.get(id);
    }

    public boolean exists(UUID id) {
        return games.containsKey(id);
    }
}