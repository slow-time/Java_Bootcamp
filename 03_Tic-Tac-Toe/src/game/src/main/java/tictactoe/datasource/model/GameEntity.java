package tictactoe.datasource.model;

import java.util.UUID;

public class GameEntity {
    private final UUID id;
    private final GameFieldEntity field;

    public GameEntity(UUID id, GameFieldEntity field) {
        this.id = id;
        this.field = field;
    }

    public UUID getId() {
        return id;
    }

    public GameFieldEntity getField() {
        return field;
    }
}