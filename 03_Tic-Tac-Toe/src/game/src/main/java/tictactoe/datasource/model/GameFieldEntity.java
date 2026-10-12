package tictactoe.datasource.model;

import java.util.Arrays;

public class GameFieldEntity {
    private int[][] field;

    public GameFieldEntity() {
        this.field = new int[3][3];
    }

    public GameFieldEntity(int[][] field) {
        this.field = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(field[i], 0, this.field[i], 0, 3);
        }
    }

    public int[][] getField() {
        int[][] copy = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(field[i], 0, copy[i], 0, 3);
        }
        return copy;
    }

    public void setField(int[][] field) {
        this.field = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(field[i], 0, this.field[i], 0, 3);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameFieldEntity that = (GameFieldEntity) o;
        return Arrays.deepEquals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(field);
    }
}