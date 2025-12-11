import javax.swing.SwingUtilities;

import View.SudokuFrame;

public class SudokuSolverApplication {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SudokuFrame();
            }
        });
    }
}
