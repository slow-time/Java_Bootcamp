package tictactoe.datasource.repository.impl;

import tictactoe.domain.model.Game;
import tictactoe.datasource.repository.GameRepository;
import tictactoe.datasource.storage.GameStorage;
import tictactoe.datasource.mapper.DataSourceMapper;
import java.util.Optional;
import java.util.UUID;

public class GameRepositoryImpl implements GameRepository {
    private final GameStorage storage;
    private final DataSourceMapper mapper;

    public GameRepositoryImpl(GameStorage storage, DataSourceMapper mapper) {
        this.storage = storage;
        this.mapper = mapper;
    }

    @Override
    public Game save(Game game) {
        storage.save(mapper.toEntity(game));
        return game;
    }

    @Override
    public Optional<Game> findById(UUID id) {
        return Optional.ofNullable(mapper.toDomain(storage.findById(id)));
    }

    @Override
    public boolean exists(UUID id) {
        return storage.exists(id);
    }
}