package View;

import javax.swing.JPanel;

public class SudokuPanel {

	private JPanel sudokuPanel;
	
	
	public SudokuPanel()
	{
		
		this.sudokuPanel = new JPanel();
		sudokuPanel.setBackground(java.awt.Color.CYAN);
	}
	
	public JPanel getComponent() {
		return this.sudokuPanel;
	}
	
	
	
}
