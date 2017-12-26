package resources;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RowPanel extends JPanel {
	private JTextField[] colTextFields; 
	
	/**
	 * Constructor, creates a row for bot
	 * @param cols		Number of labels
	 * @param width		width
	 * @param height	Height
	 */
	
	public RowPanel (int cols, int width, int height) {
		colTextFields = new JTextField[cols];
		setPreferredSize(new Dimension(width,height));
		setBorder(new EmptyBorder(10,40,0,20));
		setLayout(new GridLayout(1,cols,4,4));
		
		for (int col=0; col<cols; col++) {
			colTextFields[col] = new JTextField("0");
			colTextFields[col].setHorizontalAlignment(JTextField.CENTER);
			add(colTextFields[col]);
		}
	}
	
	/**
	 * Set Row-method
	 * @param array array7
	 */
	public void setRow(Array7 array) {
		for (int i=0; i<7; i++) {
			colTextFields[i].setText(""+array.getElement(i));
		}
	}
	
	/**
	 * Get row-method
	 * @return Bot row as 7x1 array
	 */
	public int[] getRow() {
		int[] res = new int[7];
		for (int i=0; i<7; i++) {
			res[i] = Integer.parseInt(colTextFields[i].getText());
		}
		return res;
	}
	

}