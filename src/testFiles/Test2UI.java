package testFiles;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import controllers.Controller;
import resources.*;
import p6.*;


/**
 * UI som används i moment 3, uppgift 5.
 * @author Oscar
 *
 */
public class Test2UI extends JFrame implements ActionListener {

	private Controller controller;
	private ArrayPanel arrayPanel = new ArrayPanel(7,7,250,200);
	private ColPanel leftColPanel = new ColPanel(7, 30, 200);
	private ColPanel rightColPanel = new ColPanel(7, 30, 200);
	
	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();

	private JButton leftButton = new JButton("Flytta vänster");
	private JButton rightButton = new JButton("Flytta höger");

	/**
	 * Konstruktor. Skapar paneler och lägger till dessa i JFramen
	 */
	public Test2UI() {
		createMainPanel();
		createButtonPanel();
		add (mainPanel, BorderLayout.CENTER);
		add (buttonPanel, BorderLayout.SOUTH);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * Skapar den centrerade panelen som i sin tur innehåller paneler med JLabels och TextFields.
	 */
	public void createMainPanel() {
		mainPanel.setPreferredSize(new Dimension(400,300));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(arrayPanel, BorderLayout.CENTER);
		mainPanel.add(leftColPanel, BorderLayout.WEST);
		mainPanel.add(rightColPanel, BorderLayout.EAST);
		mainPanel.setBorder(new EmptyBorder(30,30,30,30));
	}
	
	/**
	 * Skapar panel med JButtons
	 */
	public void createButtonPanel() {
		buttonPanel.setLayout(new GridLayout(1,2,20,20));
		buttonPanel.add(leftButton);
		buttonPanel.add(rightButton);
		buttonPanel.setBorder(new EmptyBorder(0,30,30,30));
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
	}
	
	/**
	 * Set-metod för JLabels. Skickar allting vidare till metod som finns i arrayPanel-klassen.
	 * @param row vilken rad
	 * @param col vilken kolumn
	 * @param val vilket värde
	 */
	public void setArrLabels(int row, int col, int val) {
		this.arrayPanel.setArrLabel(row, col, val);
	}
	
	/**
	 * Set-metod för JTextFields. Skickar allting vidare till colPanel-klassen.
	 * @param direction bestämmer om textfältet som ska ändras finns i höger eller vänster kolumn 
	 * @param row vilken rad
	 * @param val vilket värde
	 */
	public void setColTextField(char direction, int row, int val) {
		if (direction == 'l') {
			this.leftColPanel.setColTextField(row, val);
		}
		else if (direction == 'r') {
			this.rightColPanel.setColTextField(row, val);
		}
	}
	
	/**
	 * Returnerar an Array7 med värdena som finns i en av textFields-kolumnerna
	 * @param direction bestämmer om det är höger eller vänster kolumn
	 * @return Array7
	 */
	public Array7 getCol(char direction) {
		if (direction == 'r') {
			return new Array7(rightColPanel.getCol());
		}
		else if (direction == 'l') {
			return new Array7(leftColPanel.getCol());
		}
		return null;
	}

	/**
	 * Används av JButtons. Anropar metod i controller.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == leftButton) {
			controller.shiftHorizontal('l');
		}
		if (e.getSource() == rightButton) {
			controller.shiftHorizontal('r');
		}
	}
	
	
}
