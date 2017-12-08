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

import controllers.Test1UIController;
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
	
	public Test1UI(Test1UIController controller) {
		this.controller = controller;
		this.controller.setUserInput(this);
		createMainPanel();
		createButtonPanel();
		addListeners();
		
		add (mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.EAST);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void createMainPanel() {
		mainPanel.setPreferredSize(new Dimension(400,300));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(arrayPanel, BorderLayout.CENTER);
		mainPanel.add(leftColPanel, BorderLayout.WEST);
		mainPanel.add(botRowPanel, BorderLayout.SOUTH);
		mainPanel.setBorder(new EmptyBorder(30,30,30,30));
	}
	
	public void createButtonPanel() {
		buttonPanel.setPreferredSize(new Dimension(150,200));
		buttonRowPanel.setLayout(new GridLayout(4,1,0,10));
		buttonRowPanel.add(rowText);
		buttonRowPanel.add(rowNbr);
		buttonRowPanel.add(readRow);
		buttonRowPanel.add(writeRow);
		
		buttonColPanel.add(colText);
		buttonColPanel.add(colNbr);
		buttonColPanel.add(readCol);
		buttonColPanel.add(writeCol);
		buttonColPanel.setLayout(new GridLayout(4,1,0,10));
		
		buttonPanel.setLayout(new GridLayout(2,1,0,10));
		buttonPanel.add(buttonRowPanel);
		buttonPanel.add(buttonColPanel);
		buttonPanel.setBorder(new EmptyBorder(30,30,30,30));
	}
	
	private void addListeners() {
		this.readRow.addActionListener(this);
		this.writeRow.addActionListener(this);
		this.readCol.addActionListener(this);
		this.writeCol.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Test1UI ui1 = new Test1UI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.readRow) {
			///Read row
		}
		if(e.getSource() == this.readCol) {
			///Read row
		}
		if(e.getSource() == this.writeRow) {
			///Read row
		}
		if(e.getSource() == this.writeCol) {
			///Read row
		}
		// TODO Auto-generated method stub
		
	}
}
