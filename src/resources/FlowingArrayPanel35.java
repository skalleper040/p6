package resources;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FlowingArrayPanel35 extends JPanel{
	private JLabel arrLabels[][] = new JLabel[7][35];

	public FlowingArrayPanel35(int cols) {
		setPreferredSize(new Dimension(400,35*400/7));
		setLayout(new GridLayout(7,35,1,1));
		setBorder(new EmptyBorder(0,0,0,0));


		for (int row=0; row<7; row++) {
			for (int col=0; col<35; col++) {
				arrLabels[row][col] = new JLabel();
				arrLabels[row][col].setBackground(Color.PINK);
				arrLabels[row][col].setOpaque(true);
				add(arrLabels[row][col]);
			}
		}
	}

	public void printCol(Array7 arr, int col) {
		for(int i = 0; i<7; i++) {
			if(arr.getElement(i)==1) {
				arrLabels[i][col].setBackground(Color.BLACK);
			}else {
				arrLabels[i][col].setBackground(Color.PINK);
			}
		}
	}
	public void printSquareOn (int row, int col) {
			arrLabels[row][col].setBackground(Color.MAGENTA);
	}
	
	public void printSquareOff (int row, int col) {
		arrLabels[row][col].setBackground(Color.PINK);

}
}
