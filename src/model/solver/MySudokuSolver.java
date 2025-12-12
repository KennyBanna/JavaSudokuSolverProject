package model.solver;

public class MySudokuSolver implements SudokuSolver {

    private int[][] board = new int[9][9];

    @Override
    public boolean solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

    @Override
    public void set(int row, int col, int digit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
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
        return false;
    }

    @Override
    public boolean isAllValid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAllValid'");
    }

    @Override
    public void setGrid(int[][] m) {

        // Checks for proper dimensions (9 by 9)
        if (m.length != 9 || m[0].length != 9) {
            throw new IllegalArgumentException();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                board[row][col] = m[row][col];

                if (!isValid(row, col)) {
                    throw new IllegalArgumentException();
                }

            }
        }
    }

    @Override
    public int[][] getGrid() {

        return null;
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
