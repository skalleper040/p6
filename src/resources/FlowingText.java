package resources;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Controller;
import controllers.FlowingController;
import controllers.FontController;

public class FlowingText extends JFrame implements ActionListener {
	private FlowingController controller;
	private FlowingArrayPanel flowingArrayPanel = new FlowingArrayPanel(35);
	private JPanel mainPanel = new JPanel();
	private JPanel botPanel = new JPanel();
	
	private String[] dropDown = {"Blinkande","Vänster","Höger","Spelvänt","Ner","Upp"};
	private JComboBox dropList = new JComboBox(dropDown);
	
	private String[] delayTimer = {"Fysatan va snabbt", "Snabbast", "Snabbare", "Normal", "Långsammare", "Långsammaste", "Kristina"};
	private JComboBox delayList = new JComboBox(delayTimer);

	private JTextField words = new JTextField();
	private JButton read = new JButton("kör");

	public FlowingText () {
		this.setLayout(new BorderLayout());
		this.add (flowingArrayPanel, BorderLayout.CENTER);
		words.setHorizontalAlignment(JTextField.CENTER);
		words.setPreferredSize(new Dimension(1500, 30));
		botPanel.add(words);
		botPanel.add(dropList);
		botPanel.add(delayList);
		botPanel.add(read);
		this.add(botPanel, BorderLayout.SOUTH);
		//this.add(read, BorderLayout.WEST);
		//this.add(dropList, BorderLayout.NORTH);
		//this.add(delayList, BorderLayout.EAST);
		read.addActionListener(this);
		dropList.addActionListener(this);
		dropList.setSelectedIndex(1);
		delayList.setSelectedIndex(3);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
		}

	public void setController(FlowingController controller) {
		this.controller = controller;
	}
	public void printSquareOn (int row, int col) {
		flowingArrayPanel.printSquareOn(row, col);
	}
	
	public void printSquareOff (int row, int col) {
		flowingArrayPanel.printSquareOff(row, col);
	}
	
	public void printCol(Array7 arr, int col) {
		flowingArrayPanel.printCol(arr, col);
	}
	
	public void shiftLeft() {
		flowingArrayPanel.shiftLeft();
	}
	
	public void shiftRight() {
		flowingArrayPanel.shiftRight();
	}
	
	public void disableButtons() {
		read.setEnabled(false);
	}
	
	public void enableButtons() {
		read.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int delay = (delayList.getSelectedIndex()*7)*(delayList.getSelectedIndex()*7) + 10;
		System.out.println(delay);		
		if(e.getSource() == read && dropList.getSelectedIndex() == 0) {
			controller.blink(words.getText(), delay);
			//timer.schedule(task, words.getText().length(), 100);
		}	
		if(e.getSource()== read && dropList.getSelectedIndex() != 0) {
			controller.scrollLeft(words.getText(), dropList.getSelectedIndex(), delay);
		}
	}	
}
