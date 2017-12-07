package testFiles;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import resources.ArrayPanel;
import resources.ColPanel;
import resources.RowPanel;

public class Test1UI extends JFrame{
	private ArrayPanel arrayPanel = new ArrayPanel(7,7,250,200);
	private ColPanel leftColPanel = new ColPanel(7, 20, 200);
	private RowPanel botRowPanel = new RowPanel(7, 200, 30);
	
	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	public Test1UI() {
		createMainPanel();
		createButtonPanel();
		
		add (mainPanel, BorderLayout.CENTER);
		add (buttonPanel, BorderLayout.SOUTH);
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
		buttonPanel.setLayout(new GridLayout(1,2,20,20));

		buttonPanel.setBorder(new EmptyBorder(0,30,30,30));
	}
	
	public static void main(String[] args) {
		Test1UI ui1 = new Test1UI();
	}
}
