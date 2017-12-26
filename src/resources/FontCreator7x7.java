package resources;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.FontController;
import controllers.Test1UIController;

public class FontCreator7x7 extends JFrame implements ActionListener{
	private ButtonArrayPanel buttonArrayPanel = new ButtonArrayPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel botPanel = new JPanel();
	private FontController controller;
	private JTextField letter = new JTextField("A");
	private JButton read = new JButton("Save");
	private JButton reset = new JButton("Reset");
	private JButton next = new JButton("Save and Next");
	private String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789!#()=?.,-_";
	
	public FontCreator7x7() {
		//this.setPreferredSize(new Dimension(900,900));
		this.setLayout(new BorderLayout());
		
		this.add (mainPanel, BorderLayout.CENTER);
		mainPanel.add (buttonArrayPanel, BorderLayout.CENTER);
		letter.setHorizontalAlignment(JTextField.CENTER);
		this.add(botPanel, BorderLayout.SOUTH);
		botPanel.setLayout(new GridLayout(4,1,10,10));
		botPanel.add(letter);
		botPanel.add(next);
		botPanel.add(read);
		botPanel.add(reset);
		read.addActionListener(this);
		reset.addActionListener(this);
		next.addActionListener(this);
		for (int row=0; row<7; row++) {
			for (int col=0; col<7; col++) {
				this.buttonArrayPanel.getButton(row, col).addActionListener(this);
			}
		}

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setController(FontController controller) {
		this.controller = controller;
	}
	
	public void clickedOn(int row, int col) {
		buttonArrayPanel.clickedOn(row, col);
	}
	
	public void reset() {
		this.buttonArrayPanel.reset();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.reset) {
			this.reset();
			controller.reset();
		}
		if(e.getSource() == this.next) {
			try {
				this.controller.toText(this.letter.getText());
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.reset();
			controller.reset();
			int index = alpha.indexOf(this.letter.getText());
			if( index < alpha.length()) {
				this.letter.setText(""+alpha.charAt(index+1));
			}
		}
		if(e.getSource() == this.read) {
			try {
				this.controller.toText(this.letter.getText());
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		for (int row=0; row<7; row++) {
			for (int col=0; col<7; col++) {
				if(e.getSource() == this.buttonArrayPanel.getButton(row, col)) {
					this.controller.clickedOn(row, col);
				}
			}
		}
	}
}
