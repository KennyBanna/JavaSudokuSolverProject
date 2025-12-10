import javax.swing.SwingUtilities;

import View.SudokuFrame;

public class SudokuSolverApplication {

    public static void main(String... args) {

    	//test
    	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SudokuFrame();
            }
        });

    }

}
