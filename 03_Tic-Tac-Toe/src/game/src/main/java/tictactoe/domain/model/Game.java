package tictactoe.domain.model;

import java.util.UUID;

public class Game {
    private final UUID id;
    private final Field field;

    public Game(UUID id, Field field) {
        this.id = id;
        this.field = field;
    }

    public UUID getId() {
        return id;
    }

    public Field getField() {
        return field;
    }

    public static Game createNew() {
        return new Game(UUID.randomUUID(), new Field());
    }

    @Override
    public String toString() {
        return "Game{" + id +
                ", \n" + field +
                '}';
    }
}