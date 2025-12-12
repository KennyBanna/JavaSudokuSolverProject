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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void clear(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public void clearAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearAll'");
    }

    @Override
    public boolean isValid(int row, int col) {
        return board[row][col] < 10 && board[row][col] >= 0;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGrid'");
    }

}
