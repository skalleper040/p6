package resources;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class FlowingArrayPanel extends JPanel{
	private JLabel arrLabels[][];
	private int array[][];
	
	public FlowingArrayPanel(int cols) {
		arrLabels = new JLabel[7][cols];
		array = new int[7][cols];
		setPreferredSize(new Dimension(cols * 350/7, 350));
		setLayout(new GridLayout(7,cols,1,1));
		setBorder(new EmptyBorder(0,0,0,0));


		for (int row=0; row<7; row++) {
			for (int col=0; col<cols; col++) {
				array[row][col] = 0;
				arrLabels[row][col] = new JLabel();
				arrLabels[row][col].setBackground(Color.PINK);
				arrLabels[row][col].setOpaque(true);
				add(arrLabels[row][col]);
			}
		}
	}

	public Array7 readCol(int col) {
		Array7 arr = new Array7();
		for(int i = 0; i<7;i++) {
			if(array[i][col]== 1) {
				arr.setElement(i, 1);
			}else {
				arr.setElement(i,0);
			}
		}
		return arr;
	}
	
	public void shiftLeft() {
		for(int i = 1; i <= 34; i++ ) {
			printCol(readCol(i), i-1);
		}
		
	}
	
	public void shiftRight() {
		for(int i = 33; i >= 0; i-- ) {
			printCol(readCol(i), i+1);
		}
		
	}
	
	public void printCol(Array7 arr, int col) {
		for(int i = 0; i<7; i++) {
			if(arr.getElement(i)==1) {
				arrLabels[i][col].setBackground(Color.MAGENTA);
				array[i][col] = 1;
			}else {
				arrLabels[i][col].setBackground(Color.PINK);
				array[i][col] = 0;
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
