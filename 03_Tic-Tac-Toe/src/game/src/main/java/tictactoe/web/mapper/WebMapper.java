package tictactoe.web.mapper;

import tictactoe.domain.model.Game;
import tictactoe.domain.model.Field;
import tictactoe.web.model.GameDto;
import tictactoe.web.model.FieldDto;
import org.springframework.stereotype.Component;

@Component
public class WebMapper {

    public GameDto toDto(Game game) {
        if (game == null) return null;
        return new GameDto(
                game.getId(),
                toDto(game.getField())
        );
    }

    public Game toDomain(GameDto dto) {
        if (dto == null) return null;
        return new Game(
                dto.getId(),
                toDomain(dto.getField())
        );
    }

    private FieldDto toDto(Field field) {
        if (field == null) return new FieldDto(new int[3][3]);
        return new FieldDto(field.getField());
    }

    private Field toDomain(FieldDto dto) {
        if (dto == null) return new Field();
        return new Field(dto.getField());
    }
}