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

/**
 * 
 * @author Johannes Roos, Angelina Fransson, Sven Lindqvist
 *
 */
public class FlowingText extends JFrame implements ActionListener {
	private FlowingController controller;
	private FlowingArrayPanel flowingArrayPanel = new FlowingArrayPanel(35);
	private JPanel botPanel = new JPanel();
	
	private String[] dropDown = {"Blinkande","Vänster","Höger","Spelvänt"};
	private JComboBox dropList = new JComboBox(dropDown);
	
	private String[] delayTimer = {"Fysatan va snabbt", "Snabbast", "Snabbare", "Normal", "Långsammare", "Långsammaste", "Kristina"};
	private JComboBox delayList = new JComboBox(delayTimer);

	private JTextField words = new JTextField();
	private JButton read = new JButton("kör");
	
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
		words.setPreferredSize(new Dimension(1500, 30));
		botPanel.add(words);
		botPanel.add(dropList);
		botPanel.add(delayList);
		botPanel.add(read);
	}
	
	/**
	 * Designs the MainFrame
	 */
	public void designMainFram() {
		this.setLayout(new BorderLayout());
		this.add (flowingArrayPanel, BorderLayout.CENTER);
		this.add(botPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Adds Actionlisteners
	 */
	public void addActionListeners() {
		read.addActionListener(this);
		dropList.addActionListener(this);
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
	 * Sets the coordinate On
	 * @param row int, the row
	 * @param col int, the col
	 */
	public void printSquareOn (int row, int col) {
		flowingArrayPanel.printSquareOn(row, col);
	}
	/**
	 * Sets the coordinate Off
	 * @param row int, the row
	 * @param col int, the col
	 */
	public void printSquareOff (int row, int col) {
		flowingArrayPanel.printSquareOff(row, col);
	}
	
	/**
	 * Prints and entire column 
	 * @param arr Arrary7, the colum to print
	 * @param col int, the position to print it
	 */
	public void printCol(Array7 arr, int col) {
		flowingArrayPanel.printCol(arr, col);
	}
	
	/**
	 * Shifts the entire board one step to the left
	 */
	public void shiftLeft() {
		flowingArrayPanel.shiftLeft();
	}
	
	/**
	 * Shifts the entire board one step to the right
	 */
	public void shiftRight() {
		flowingArrayPanel.shiftRight();
	}
	
	/**
	 * Disable Buttons
	 */
	public void disableButtons() {
		read.setEnabled(false);
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
			controller.scroll(words.getText(), dropList.getSelectedIndex(), delay);
		}
	}	
}
