package model.solver;

public class MySudokuSolver implements SudokuSolver {

    private int[][] board = new int[9][9];

    @Override
    public boolean solve() {
        if (!isAllValid()) {
            return false;
        }

        for (int i = 1; i <= 9; i++) {

        }
        return true;
    }

    // rekursiv hjälpmetod
    private boolean solve(int row, int col) {
        return false;
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
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                this.board[row][col] = 0;
            }
        }
    }

    @Override
    public boolean isValid(int row, int col) {
        // Kollar om en specifik siffra i boardet är valid
        // dvs om den är unik i rad, kolumn och 3x3 ruta

        int num = board[row][col];

        // kolla att raden är fri
        for (int c = 0; c < 9; c++) {

            if (c == col) {
                continue;
            }

            if (board[row][c] == num) {
                return false;

            }
        }

        // kolla att kolumnen är fri
        for (int r = 0; r < 9; r++) {

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
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (!isValid(r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void setGrid(int[][] m) {

        // Checks for proper dimensions (9 by 9)
        if (m.length != 9 || m[0].length != 9) {
            throw new IllegalArgumentException();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (!inBounds(m[row][col])) {
                    throw new IllegalArgumentException();
                }

                board[row][col] = m[row][col];

            }
        }
    }

    @Override
    public int[][] getGrid() {

        int[][] copyOfGrid = new int[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
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

        for (int row = 0; row < 9; row++) {
            sb.append("\n");
            sb.append("|");
            for (int col = 0; col < 9; col++) {

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
