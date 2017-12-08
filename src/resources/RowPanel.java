package resources;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RowPanel extends JPanel {
	private JTextField[] colTextFields; 
	
	public RowPanel (int cols, int width, int height) {
		colTextFields = new JTextField[cols];
		setPreferredSize(new Dimension(width,height));
		setBorder(new EmptyBorder(10,40,0,20));
		setLayout(new GridLayout(1,cols,4,4));
		
		for (int col=0; col<cols; col++) {
			colTextFields[col] = new JTextField("0");
			add(colTextFields[col]);
		}
	}
	
	public void setRow(Array7 array) {
		for (int i=0; i<7; i++) {
			colTextFields[i].setText(""+array.getElement(i));
		}
	}
	
	public int[] getRow() {
		int[] res = new int[7];
		for (int i=0; i<7; i++) {
			res[i] = Integer.parseInt(colTextFields[i].getText());
		}
		return res;
	}
}