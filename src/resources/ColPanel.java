package resources;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColPanel extends JPanel {
	private JTextField[] colTextFields = new JTextField[7];
	
	public ColPanel (int rows, int width, int height) {
		JTextField[] colTextFields = new JTextField[rows];
		setPreferredSize(new Dimension(width,height));
		setLayout(new GridLayout(rows,1,4,4));
		for (int row=0; row<rows; row++) {
			colTextFields[row] = new JTextField("0");
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
}

