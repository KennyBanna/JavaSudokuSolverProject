package model.solver;

public class MySudokuSolver implements SudokuSolver {

    private static int SIZE = 9;
    private int[][] board = new int[SIZE][SIZE];

    @Override
    public boolean solve() {
        if (!isAllValid()) {
            return false;
        }

        return solve(0, 0);
    }

    // rekursiv hjälpmetod
    private boolean solve(int row, int col) {

        // Basfall
        if (row >= 8 && col >= 8 && get(8, 8) != 0) {
            return isValid(8, 8);
        }

        // Sparar nästa ruta i variabler
        int nextCol, nextRow;
        if (col == 8) {
            nextCol = 0;
            nextRow = row + 1;
        } else {
            nextCol = col + 1;
            nextRow = row;
        }
        if (row == 8) {
            nextRow = 8;
        }

        // --- VAL ---
        // sätt ut en siffra (om inte siffra finns)
        if (get(row, col) != 0) {
            if (solve(nextRow, nextCol)) {
                return true;
            }
        } else {

            for (int d = 1; d <= SIZE; d++) { // Vi prövar sätta ut varje siffra

                set(row, col, d);

                if (isValid(row, col)) {
                    // Varje siffra gör ett rekursivt call
                    if (solve(nextRow, nextCol)) {
                        return true;
                    }
                }
            }
        }

        this.clear(row, col);

        return false;
        // Om vi gått igenom alla alternativ och ingen siffra passar måste
        // Vi backtracka

    }

    @Override
    public void set(int row, int col, int digit) {

        this.board[row][col] = digit;

    }

    @Override
    public int get(int row, int col) {
        return this.board[row][col];
    }

    @Override
    public void clear(int row, int col) {
        this.board[row][col] = 0;
    }

    @Override
    public void clearAll() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                this.board[row][col] = 0;
            }
        }
    }

    @Override
    public boolean isValid(int row, int col) {
        // Kollar om en specifik siffra i boardet är valid
        // dvs om den är unik i rad, kolumn och 3x3 ruta

        int num = board[row][col];
        if (num == 0) {
            return true;
        }

        // kolla att raden är fri
        for (int c = 0; c < SIZE; c++) {

            if (c == col) {
                continue;
            }

            if (board[row][c] == num) {
                return false;

            }
        }

        // kolla att kolumnen är fri
        for (int r = 0; r < SIZE; r++) {

            if (r == row) {
                continue;
            }

            if (board[r][col] == num) {
                return false;
            }
        }

        // kolla regionen
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {

                if (c == col && r == row) {
                    continue;
                }

                if (board[r][c] == num) {
                    return false;
                }

            }
        }

        return true;
    }

    @Override
    public boolean isAllValid() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (!isValid(r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void setGrid(int[][] m) {

        // Checks for proper dimensions (SIZE by SIZE)
        if (m.length != SIZE || m[0].length != SIZE) {
            throw new IllegalArgumentException();
        }

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (!inBounds(m[row][col])) {
                    throw new IllegalArgumentException();
                }

                board[row][col] = m[row][col];

            }
        }
    }

    @Override
    public int[][] getGrid() {

        int[][] copyOfGrid = new int[SIZE][SIZE];

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                copyOfGrid[r][c] = this.board[r][c];
            }
        }
        return copyOfGrid;
    }

    private boolean inBounds(int num) {
        return num < 10 && num >= 0;
    }

    public String toString() {

        String line = "----------------------";

        StringBuilder sb = new StringBuilder(line);

        for (int row = 0; row < SIZE; row++) {
            sb.append("\n");
            sb.append("|");
            for (int col = 0; col < SIZE; col++) {

                int digit = board[row][col];

                if (digit == 0) {
                    sb.append(" ").append("_");
                } else {
                    sb.append(" ").append(digit);
                }

                if ((col + 1) % 3 == 0) {
                    sb.append("|");
                }

            }

            if ((row + 1) % 3 == 0) {
                sb.append("\n" + line);
            }
        }

        return sb.toString();
    }
}
