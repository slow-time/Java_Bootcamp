package tictactoe.domain.model;

public class Field {
    private final int[][] field;

    public Field(){
        this.field = new int[3][3];
    }

    public Field(int[][] field) {
        this.field = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(field[i], 0, this.field[i], 0, 3);
        }
    }

    public int getCell(int row, int col) {
        return field[row][col];
    }

    public void setCell(int row, int col, int value) {
        field[row][col] = value;
    }

    public int[][] getField() {
        int[][] copy = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(field[i], 0, copy[i], 0, 3);
        }
        return copy;
    }

    public boolean isEmpty(int row, int col) {
        return field[row][col] == 0;
    }


    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(field[i][j] != 0) {
                    setCell(i, j, 0);
                }
            }
        }
    }
}
