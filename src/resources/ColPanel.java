package resources;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColPanel extends JPanel {
	private JTextField[] colTextFields = new JTextField[7];
	
	/**
	 * Constructor, creates a col of labels
	 * @param cols		Number of labels
	 * @param width		Width
	 * @param height	Height
	 */
	public ColPanel (int rows, int width, int height) {
		setPreferredSize(new Dimension(width,height));
		setLayout(new GridLayout(rows,1,4,4));
		for (int row=0; row<rows; row++) {
			colTextFields[row] = new JTextField("0");
			colTextFields[row].setHorizontalAlignment(JTextField.CENTER);
			add(colTextFields[row]);
		}
	}
	
	/**
	 * Sätt värdet på en rad
	 * @param row vilken rad
	 * @param val vilket värde
	 */
	
	public void setColTextField(int row, int val) {
		this.colTextFields[row].setText(""+val);
	}
	
	/**
	 * Byter text på kolumnen av JLabels
	 * @param array Array7-objekt
	 */
	public void setCol(Array7 array) {
		for (int i=0; i<7; i++) {
			colTextFields[i].setText(""+array.getElement(i));
		}
	}
	
	/**
	 * Get column method
	 * @return Left column as a 7x1 array
	 */
	
	public int[] getCol() {
		int[] res = new int[7];
		for (int i=0; i<7; i++) {
			res[i] = Integer.parseInt(colTextFields[i].getText());
		}
		return res;
	}
}

