package tictactoe.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldDto {
    private final int[][] field;


    @JsonCreator
    public FieldDto(@JsonProperty("field") int[][] field) {
        this.field = new int[3][3];
        if (field != null) {
            for (int i = 0; i < Math.min(3, field.length); i++) {
                if (field[i] != null) {
                    System.arraycopy(field[i], 0, this.field[i], 0,
                            Math.min(3, field[i].length));
                }
            }
        }
    }


    public int[][] getField() {
        int[][] copy = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(field[i], 0, copy[i], 0, 3);
        }
        return copy;
    }
}