package resources;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Panel of JLabels used in the flowingtext class
 * @author Johannes Roos, Angelina Fransson, Sven Lindqvist
 *
 */
public class FlowingArrayPanel extends JPanel{
	private JLabel arrLabels[][];
	private int array[][];
	
	/**
	 * Creates a 7xCols array of labels
	 * @param cols int, the number of columns
	 */
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

	/**
	 * Reads an entire column and returns a Array7-object
	 * @param col int, the column to read
	 * @return Array7
	 */
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
	
	/**
	 * Shifts the entire array one step left
	 */
	public void shiftLeft() {
		for(int i = 1; i <= 34; i++ ) {
			printCol(readCol(i), i-1);
		}
		
	}
	/**
	 * Shifts the entire array one step right
	 */
	public void shiftRight() {
		for(int i = 33; i >= 0; i-- ) {
			printCol(readCol(i), i+1);
		}
		
	}
	
	/**
	 * Prints an entire column
	 * @param arr Array7, the array to print
	 * @param col int, where to print it
	 */
	public void printCol(Array7 arr, int col) {
		for(int i = 0; i<7; i++) {
			if(arr.getElement(i)==1) {
				printSquareOn(i, col);
				array[i][col] = 1;
			}else {
				printSquareOff(i, col);
				array[i][col] = 0;
			}

		}
	}
	
	/**
	 * Changes backgroundcolor to Magenta on one specific label
	 * @param row int, the row
	 * @param col int, the col
	 */
	public void printSquareOn (int row, int col) {
			arrLabels[row][col].setBackground(Color.MAGENTA);
	}
	
	/**
	 * Changes backgroundcolor to Pink on one specific label
	 * @param row int, the row
	 * @param col int, the col
	 */
	public void printSquareOff (int row, int col) {
		arrLabels[row][col].setBackground(Color.PINK);

}

}
