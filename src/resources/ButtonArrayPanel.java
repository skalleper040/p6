package resources;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ButtonArrayPanel extends JPanel{

	private JButton arrLabels[][] = new JButton[7][7];

	public ButtonArrayPanel() {
		setPreferredSize(new Dimension(400,400));
		setLayout(new GridLayout(7,7,0,0));
		setBorder(new EmptyBorder(0,0,0,0));


		for (int row=0; row<7; row++) {
			for (int col=0; col<7; col++) {
				arrLabels[row][col] = new JButton();
				arrLabels[row][col].setBackground(Color.WHITE);
				arrLabels[row][col].setOpaque(true);
				add(arrLabels[row][col]);
			}
		}
	}

	public JButton getButton(int row, int col) {
		return arrLabels[row][col];
	}
	public void clickedOn(int row, int col) {
		System.out.println(row +" " + col);
		if(arrLabels[row][col].getBackground() == Color.WHITE) {
			arrLabels[row][col].setBackground(Color.BLACK);
		}else {
			arrLabels[row][col].setBackground(Color.WHITE);
		}
	}

	public void reset() {
		for (int row=0; row<7; row++) {
			for (int col=0; col<7; col++) {
				arrLabels[row][col].setBackground(Color.WHITE);
			}
		}
	}
}