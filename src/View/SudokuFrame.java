package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

public class SudokuFrame {

    private JFrame SudokuFrame;

    public SudokuFrame() {
        SudokuFrame = new JFrame("Sudokulösare");

        JPanel testPanel = new JPanel();
        testPanel.setPreferredSize(new Dimension(600, 400));

        SudokuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SudokuFrame.add(testPanel);
        SudokuFrame.setVisible(true);
        SudokuFrame.pack();
        centerWindow();
    }

    private void centerWindow() {

        int width = SudokuFrame.getWidth();
        int height = SudokuFrame.getHeight();

        int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;

        int posX = screenW / 2 - width / 2;
        int posY = screenH / 2 - height / 2;

        SudokuFrame.setLocation(new Point(posX, posY));

        System.out.printf("%s, %s, %s, %s", width, height, screenW, screenH);
    };

}
