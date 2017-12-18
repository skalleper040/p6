package resources;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Controller;
import controllers.FlowingController;
import controllers.FontController;

public class FlowingText extends JFrame implements ActionListener {
	private FlowingController controller;
	private FlowingArrayPanel arrayPanel = new FlowingArrayPanel();
	private JPanel mainPanel = new JPanel();
	
	private JTextField words = new JTextField();
	private JButton read = new JButton("kör");
	
	public FlowingText () {
		this.setLayout(new BorderLayout());
		
		this.add (mainPanel, BorderLayout.CENTER);
		mainPanel.add (arrayPanel, BorderLayout.CENTER);
		words.setHorizontalAlignment(JTextField.CENTER);
		this.add(words, BorderLayout.SOUTH);
		this.add(read, BorderLayout.WEST);
		read.addActionListener(this);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setController(FlowingController controller) {
		this.controller = controller;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == read) {
			controller.printText(words.getText());
		}
		
	}

	
}
