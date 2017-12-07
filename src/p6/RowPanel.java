package p6;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class RowPanel extends JPanel {
	
	public RowPanel (int cols, int width, int height) {
		JTextField[] colTextFields = new JTextField[cols];
		setPreferredSize(new Dimension(width,height));
		setLayout(new GridLayout(1,cols,4,4));
		setBorder(new Bord);
		for (int col=0; col<cols; col++) {
			colTextFields[col] = new JTextField("0");
			add(colTextFields[col]);
		}
	}
}