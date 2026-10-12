package tictactoe.datasource.mapper;

import tictactoe.datasource.model.GameEntity;
import tictactoe.datasource.model.GameFieldEntity;
import tictactoe.domain.model.Game;
import tictactoe.domain.model.Field;
import org.springframework.stereotype.Component;

@Component
public class DataSourceMapper {

    public Game toDomain(GameEntity entity) {
        if (entity == null) return null;
        return new Game(
                entity.getId(),
                toDomain(entity.getField())
        );
    }

    public GameEntity toEntity(Game game) {
        if (game == null) return null;
        return new GameEntity(
                game.getId(),
                toEntity(game.getField())
        );
    }

    public Field toDomain(GameFieldEntity entity) {
        if (entity == null) return new Field();
        return new Field(entity.getField());
    }

    public GameFieldEntity toEntity(Field field) {
        if (field == null) return new GameFieldEntity();
        return new GameFieldEntity(field.getField());
    }
}