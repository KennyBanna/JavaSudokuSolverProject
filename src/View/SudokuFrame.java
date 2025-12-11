package View;

import javax.swing.*;
import java.awt.*;

public class SudokuFrame extends JFrame {

    public SudokuFrame() {
        super("Sudokulösare");

        SudokuPanel sudokuPanel = new SudokuPanel();
        sudokuPanel.setPreferredSize(new Dimension(600, 400));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(sudokuPanel);
        pack();
        setLocationRelativeTo(null); // centrera
        setVisible(true);
    }
}
