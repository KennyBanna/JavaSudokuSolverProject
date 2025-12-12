package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.solver.SudokuSolver;
import model.solver.MySudokuSolver;

public class SudokuPanel extends JPanel {

    private static final int SIZE = 9;

    private JTextField[][] cells;
    private SudokuSolver solver;

    public SudokuPanel() {
        solver = new MySudokuSolver();
        initGui();
    }

    private void initGui() {
        setLayout(new BorderLayout());

        cells = new JTextField[SIZE][SIZE];

        JPanel gridPanel = new JPanel(new GridLayout(SIZE, SIZE));
        Font cellFont = new Font("SansSerif", Font.BOLD, 20);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                JTextField tf = new JTextField(1);
                tf.setHorizontalAlignment(JTextField.CENTER);
                tf.setFont(cellFont);

                // lite block-färg så man ser 3x3
                if (((r / 3) + (c / 3)) % 2 == 0) {
                    tf.setBackground(new Color(230, 230, 230));
                } else {
                    tf.setBackground(Color.WHITE);
                }

                cells[r][c] = tf;
                gridPanel.add(tf);
            }
        }

        JButton solveButton = new JButton("Solve");
        JButton clearButton = new JButton("Clear");

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveClicked();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearClicked();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);
        buttonPanel.add(clearButton);

        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void solveClicked() {
        int[][] grid = new int[SIZE][SIZE];

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                String text = cells[r][c].getText().trim();

                if (text.isEmpty()) {
                    grid[r][c] = 0; // tom ruta
                } else {
                    if (!text.matches("[1-9]")) {
                        JOptionPane.showMessageDialog(
                                this,
                                "Fel i rad " + (r + 1) + ", kolumn " + (c + 1)
                                        + ". Skriv bara siffrorna 1–9 eller lämna tomt.",
                                "Felaktig inmatning",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    grid[r][c] = Integer.parseInt(text);
                }
            }
        }

        try {
            solver.setGrid(grid);
            boolean solved = solver.solve();

            if (solved) {
                int[][] solution = solver.getGrid();
                showSolution(solution);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingen lösning hittades.\nProva att ändra några siffror och försök igen.",
                        "Ingen lösning",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ett fel uppstod i solvern: " + ex.getMessage(),
                    "Fel",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showSolution(int[][] solution) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                cells[r][c].setText(Integer.toString(solution[r][c]));
            }
        }
    }

    private void clearClicked() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                cells[r][c].setText("");
            }
        }

        try {
            solver.clearAll();
        } catch (Exception e) {

        }
    }
}
