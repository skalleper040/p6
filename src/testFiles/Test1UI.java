package testFiles;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controllers.Controller;
import controllers.Test1UIController;
import resources.Array7;
import resources.ArrayPanel;
import resources.ColPanel;
import resources.RowPanel;

public class Test1UI extends JFrame implements ActionListener{
	private Test1UIController controller;
	private ArrayPanel arrayPanel = new ArrayPanel(7,7,250,200);
	private ColPanel leftColPanel = new ColPanel(7, 20, 200);
	private RowPanel botRowPanel = new RowPanel(7, 200, 30);
	
	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	private JPanel buttonRowPanel = new JPanel();
	private JPanel buttonColPanel = new JPanel();
	
	private JLabel rowText = new JLabel("Rad");
	private JLabel colText = new JLabel("Kolumn");
	private JButton readRow = new JButton("Läs rad");
	private JButton writeRow = new JButton("Skriv rad");
	private JButton readCol = new JButton("Läs kolumn");
	private JButton writeCol = new JButton("Skriv kolumn");
	
	private JTextField rowNbr = new JTextField();
	private JTextField colNbr = new JTextField();
	
	public Test1UI() {
		setPreferredSize(new Dimension(1800,600));
		//this.controller.setUserInput(this);
		createMainPanel();
		createButtonPanel();	
		addListeners();
		
		add (mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.EAST);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Creates main-layout
	 */
	public void createMainPanel() {
		mainPanel.setPreferredSize(new Dimension(400,300));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(arrayPanel, BorderLayout.CENTER);
		mainPanel.add(leftColPanel, BorderLayout.WEST);
		mainPanel.add(botRowPanel, BorderLayout.SOUTH);
		mainPanel.setBorder(new EmptyBorder(30,30,30,30));
	}
	
	/**
	 * Creates the layout for the buttons on the right side. 
	 */
	public void createButtonPanel() {
		buttonRowPanel.setLayout(new GridLayout(4,1,0,10));
		buttonRowPanel.add(rowText);
		rowNbr.setHorizontalAlignment(JTextField.CENTER);
		buttonRowPanel.add(rowNbr);
		buttonRowPanel.add(readRow);
		buttonRowPanel.add(writeRow);
		
		buttonColPanel.add(colText);
		colNbr.setHorizontalAlignment(JTextField.CENTER);
		buttonColPanel.add(colNbr);
		buttonColPanel.add(readCol);
		buttonColPanel.add(writeCol);
		buttonColPanel.setLayout(new GridLayout(4,1,0,10));
		
		buttonPanel.setLayout(new GridLayout(2,1,0,10));
		buttonPanel.add(buttonRowPanel);
		buttonPanel.add(buttonColPanel);
		buttonPanel.setBorder(new EmptyBorder(30,30,30,30));
	}
	
	/**
	 * Adds listeners to all buttons
	 */
	private void addListeners() {
		this.readRow.addActionListener(this);
		this.writeRow.addActionListener(this);
		this.readCol.addActionListener(this);
		this.writeCol.addActionListener(this);
	}
	
	public void setController(Test1UIController controller) {
		this.controller = controller;
	}
	
	/**
	 * Updates the value in selected position
	 * @param row	Row
	 * @param col	Column
	 * @param val	Value for selected position
	 */
	public void setArrLabels(int row, int col, int val) {
		this.arrayPanel.setArrLabel(row, col, val);
	}
	
	/**
	 * Returns value in the Row-number label
	 * @return Row-number
	 */
	public int getRowNbr() {
		return Integer.parseInt(rowNbr.getText());
	}
	
	/**
	 * Sets Bottom Row
	 * @param array Array7 array
	 */
	public void setBotRow(Array7 array) {
		botRowPanel.setRow(array);
	}
	
	/**
	 * Returns value in the Col-number label
	 * @return Col-number
	 */
	public int getColNbr() {
		return Integer.parseInt(colNbr.getText());
	}
	
	/**
	 * Sets Left Column
	 * @param array Array7 array
	 */
	public void setLeftCol(Array7 array) {
		leftColPanel.setCol(array);
	}
	
	/**
	 * Get-method for bottom row
	 * @return Bottom row-labels as array7
	 */
	public Array7 getBotRow() {
		return new Array7(botRowPanel.getRow());
	}
	
	/**
	 * Get method for left column
	 * @return Left column as array7
	 */
	public Array7 getLeftCol() {
		return new Array7(leftColPanel.getCol());
	}
	
	/**
	 * Action-method.
	 * Always calls the controller.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.readRow) {
			controller.read(true);
		}
		if(e.getSource() == this.readCol) {
			controller.read(false);
		}
		if(e.getSource() == this.writeRow) {
			controller.write(true);
		}
		if(e.getSource() == this.writeCol) {
			controller.write(false);
		}
	}
}
