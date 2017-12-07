package testFiles;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.Controller;
import resources.*;
import p6.*;

public class Test2UI extends JFrame {

	private Controller controller;
	private ArrayPanel arrayPanel = new ArrayPanel(7,7,250,200);
	private ColPanel leftColPanel = new ColPanel(7, 20, 200);
	private ColPanel rightColPanel = new ColPanel(7, 20, 200);
	
	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();

	private JButton leftButton = new JButton("Flytta vänster");
	private JButton rightButton = new JButton("Flytta höger");

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
	
	public void createMainPanel() {
		mainPanel.setPreferredSize(new Dimension(400,300));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(arrayPanel, BorderLayout.CENTER);
		mainPanel.add(leftColPanel, BorderLayout.WEST);
		mainPanel.add(rightColPanel, BorderLayout.EAST);
		mainPanel.setBorder(new EmptyBorder(30,30,30,30));
	}
	
	public void createButtonPanel() {
		buttonPanel.setLayout(new GridLayout(1,2,20,20));
		buttonPanel.add(leftButton);
		buttonPanel.add(rightButton);
		buttonPanel.setBorder(new EmptyBorder(0,30,30,30));
	}
	
	public void setArrLabels(int row, int col, int val) {
		this.arrayPanel.setArrLabel(row, col, val);
	}
}
