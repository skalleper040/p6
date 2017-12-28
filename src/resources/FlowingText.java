package resources;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Controller;
import controllers.FlowingController;
import controllers.FontController;

public class FlowingText extends JFrame implements ActionListener {
	private FlowingController controller;
	private FlowingArrayPanel flowingArrayPanel = new FlowingArrayPanel();
	private JPanel mainPanel = new JPanel();
	private Timer timer = new Timer ();
	TimerTask task;


	private JTextField words = new JTextField();
	private JButton read = new JButton("kör");

	public FlowingText () {
		this.setLayout(new BorderLayout());
		this.add (mainPanel, BorderLayout.CENTER);
		mainPanel.add (flowingArrayPanel, BorderLayout.CENTER);
		words.setHorizontalAlignment(JTextField.CENTER);
		this.add(words, BorderLayout.SOUTH);
		this.add(read, BorderLayout.WEST);
		read.addActionListener(this);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	}

	public void setController(FlowingController controller) {
		this.controller = controller;
	}
	public void printSquare (Array7x7 arr, int row, int col) {
		flowingArrayPanel.printSquare(arr, row, col);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		task = new TimerTask() {
			int counter = 0; 

			@Override
			public void run() {
				if (counter < words.getText().length()) {
					controller.printText(String.valueOf(words.getText().charAt(counter)));
					System.out.println(counter);
					counter++;
				} else {
					counter = 0;
					cancel();
				}
			}
		};

		if(e.getSource() == read) {
			
			timer.schedule(task, words.getText().length()-2, 1000);
		}	
	}	
}
