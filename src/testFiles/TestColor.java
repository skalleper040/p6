package testFiles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ColorController;
import p6.Color;
import p6.ColorDisplay;
import resources.Array7;
import resources.Array7x7;
import resources.ArrayPanel;
import resources.ColPanel;

/**
 * UI som används i moment 6, Color-implementering
 * @author Carin Liljequist
 *
 */
public class TestColor extends JFrame implements ActionListener {
	private ColorController colcontroller;
	private ColorDisplay colorDisplay = new ColorDisplay(Color.WHITE, Color.LTGRAY);
	private ColPanel leftColPanel = new ColPanel(7, 30, 200);
	private ColPanel rightColPanel = new ColPanel(7, 30, 200);
	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel gridPanel = new JPanel();
	private JButton leftButton = new JButton("Flytta vänster");
	private JButton rightButton = new JButton("Flytta höger");
	private JButton swapButton = new JButton("Växla position på hörn");
	private JButton randomSwapButton = new JButton("Växla två randomiserade färger");

	public TestColor() {
		createMainPanel();
		createButtonPanel();
		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setColorController(ColorController colcontroller) {
		this.colcontroller = colcontroller;
	}

	public void createMainPanel() {
		mainPanel.setPreferredSize(new Dimension(400, 300));
		mainPanel.setLayout(new BorderLayout());
		gridPanel.add(colorDisplay);
		mainPanel.add(colorDisplay, BorderLayout.CENTER);
		mainPanel.add(leftColPanel, BorderLayout.WEST);
		mainPanel.add(rightColPanel, BorderLayout.EAST);
		mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
	}

	public void createButtonPanel() {
		buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
		buttonPanel.add(swapButton);
		buttonPanel.add(randomSwapButton);
		buttonPanel.add(leftButton);
		buttonPanel.add(rightButton);
		buttonPanel.setBorder(new EmptyBorder(0, 30, 30, 30));
		leftButton.addActionListener(this);
		swapButton.addActionListener(this);
		randomSwapButton.addActionListener(this);
		rightButton.addActionListener(this);
	}
	
	public void setColTextField(char direction, int row, int val) {
		if (direction == 'l') {
			this.leftColPanel.setColTextField(row, val);
		} else if (direction == 'r') {
			this.rightColPanel.setColTextField(row, val);
		}
	}

	public Array7 getCol(char direction) {
		if (direction == 'r') {
			return new Array7(rightColPanel.getCol());
		} else if (direction == 'l') {
			return new Array7(leftColPanel.getCol());
		}
		return null;
	}
	

	public void setCol(char direction, Array7 col) {
		if (direction == 'r') {
			rightColPanel.setCol(col);
		} else if (direction == 'l') {
			leftColPanel.setCol(col);
		}
	}
	
	public void updateDisplay() {
		this.colorDisplay.updateDisplay();
	}
	
	/**
	 *  Uppdaterar alla färger så att de är helt opaque
	 */
	public void updateColorDisplay(Array7x7 colors) {
		int iColors[][] = colors.toIntArray(); // toIntArray() --> returnerar en 2d-array med lika värden som aktuellt objekt
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				iColors[row][col] |= (0xFF << 24); // 100% opaque
			}
		}
		this.colorDisplay.setDisplay(iColors);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == leftButton) {
			colcontroller.shiftInCol('l');
		}
		if (e.getSource() == swapButton) {
			colcontroller.twoCellsSwap();
		}
		if (e.getSource() == randomSwapButton) {
			colcontroller.randomSwap();
		}
		if (e.getSource() == rightButton) {
			colcontroller.shiftInCol('r');
		}
	}
}