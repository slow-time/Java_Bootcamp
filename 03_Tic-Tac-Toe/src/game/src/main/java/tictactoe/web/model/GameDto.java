package tictactoe.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class GameDto {
    private final UUID id;
    private final FieldDto field;

    @JsonCreator
    public GameDto(
            @JsonProperty("id") UUID id,
            @JsonProperty("field") FieldDto field) {
        this.id = id;
        this.field = field;
    }

    public UUID getId() {
        return id;
    }

    public FieldDto getField() {
        return field;
    }
}