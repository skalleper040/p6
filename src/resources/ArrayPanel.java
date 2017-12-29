package resources;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ArrayPanel extends JPanel {
	private JLabel arrLabels[][] = new JLabel[7][7];
	
	
	/**
	 * Konstruktor
	 * 
	 * @param rows antal rader i griden
	 * @param cols antal kolumner i griden
	 * @param width bredden på panelen
	 * @param height höjden på panelen
	 */
	
	public ArrayPanel(int rows, int cols, int width, int height) {
		setPreferredSize(new Dimension(width,height));
		setLayout(new GridLayout(rows,cols,4,4));
		setBorder(new EmptyBorder(0,20,0,20));
	
		
		for (int row=0; row<rows; row++) {
			for (int col=0; col<cols; col++) {
				arrLabels[row][col] = new JLabel("1", SwingConstants.CENTER);
				arrLabels[row][col].setBackground(java.awt.Color.LIGHT_GRAY);
				arrLabels[row][col].setOpaque(true);
				add(arrLabels[row][col]);
			}
		}
	}
	
	/**
	 * Sätter värdet på en JLabel
	 * 
	 * @param row vilken rad
	 * @param col vilken kolumn
	 * @param val vilket värde
	 */
	public void setArrLabel(int row, int col, int val) {
		this.arrLabels[row][col].setText(""+val);
	}
}
