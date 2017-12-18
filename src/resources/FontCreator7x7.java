package resources;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

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
	private FontController controller;
	private JTextField letter = new JTextField();
	private JButton read = new JButton("Skriv till c:\\output.txt");
	private JButton reset = new JButton("Reset");
	public FontCreator7x7() {
		//this.setPreferredSize(new Dimension(900,900));
		this.setLayout(new BorderLayout());
		
		this.add (mainPanel, BorderLayout.CENTER);
		mainPanel.add (buttonArrayPanel, BorderLayout.CENTER);
		letter.setHorizontalAlignment(JTextField.CENTER);
		this.add(letter, BorderLayout.SOUTH);
		this.add(read, BorderLayout.WEST);
		read.addActionListener(this);
		this.add(reset, BorderLayout.NORTH);
		reset.addActionListener(this);
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
