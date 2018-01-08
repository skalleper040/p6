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
import p6.*;

/**
 * 
 * @author Johannes Roos, Angelina Fransson, Sven Lindqvist
 *
 */
public class FlowingText extends JFrame implements ActionListener {
	private FlowingController controller;
	private ColorDisplay display = new ColorDisplay(1,5,Color.CYAN,Color.BLACK);
	private JPanel botPanel = new JPanel();
	
	private String[] dropDown = {"Blinkande","Vänster","Höger"};
	private JComboBox dropList = new JComboBox(dropDown);
	
	private String[] delayTimer = {"Fysatan va snabbt", "Snabbast", "Snabbare", "Normal", "Långsammare", "Långsammaste", "Kristina"};
	private JComboBox delayList = new JComboBox(delayTimer);

	private JTextField words = new JTextField();
	private JButton read = new JButton("kör");

	private JButton stopBtn = new JButton("STOP");
	/**
	 * Creates the main-frame
	 */
	public FlowingText () {
		designMainFram();
		createBotPanel();	
		addActionListeners();
		setSelectedIndex();

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
		}
	
	/**
	 * Creates and designs the bottompanel
	 */
	public void createBotPanel() {
		words.setHorizontalAlignment(JTextField.CENTER);
		words.setPreferredSize(new Dimension(1000, 30));
		botPanel.add(words);
		botPanel.add(dropList);
		botPanel.add(delayList);
		botPanel.add(read);
		botPanel.add(stopBtn);
	}
	
	/**
	 * Designs the MainFrame
	 */
	public void designMainFram() {
		this.setLayout(new BorderLayout());
		this.add (display, BorderLayout.CENTER);
		this.add(botPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Adds Actionlisteners
	 */
	public void addActionListeners() {
		read.addActionListener(this);
		dropList.addActionListener(this);
		stopBtn.addActionListener(this);
	}
	
	/**
	 * Sets preselected in the dropdownlist
	 */
	public void setSelectedIndex() {
		dropList.setSelectedIndex(1);
		delayList.setSelectedIndex(3);
	}

	/**
	 * Sets the controller connected to this object
	 * @param controller
	 */
	public void setController(FlowingController controller) {
		this.controller = controller;
	}
	
	/**
	 * Disable Buttons
	 */
	public void disableButtons() {
		read.setEnabled(false);
	}
	
	public void setDisplay(int[][] colors) {
		display.setDisplay(colors);
		display.updateDisplay();
	}
	
	public void setDisplay(int[][] colors, int rows, int cols) {
		display.setDisplay(colors, rows, cols);
		display.updateDisplay();
	}
	/**
	 * Enable Buttons
	 */
	public void enableButtons() {
		read.setEnabled(true);
	}

	/**
	 * ActionListener, decides where to go depending on the dropdownlists
	 */
	@Override
	public void actionPerformed(ActionEvent e) {	
		int delay = (delayList.getSelectedIndex()*7)*(delayList.getSelectedIndex()*7) + 10;
	
		if(e.getSource() == read && dropList.getSelectedIndex() == 0) {
			controller.blink(words.getText(), delay);

		}	
		if(e.getSource()== read && dropList.getSelectedIndex() != 0) {
			controller.scroll(words.getText(), delay, dropList.getSelectedIndex());
		}
		
		if(e.getSource() == stopBtn) {
			controller.stop();
		}
		
	}	
	public void clearDisplay() {
		display.clearDisplay();
	}
}
