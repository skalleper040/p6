package p6;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ArrayPanel extends JPanel {
	private JLabel arrLabels[][] = new JLabel[7][7];
	
	public ArrayPanel(int rows, int cols, int width, int height) {
		setPreferredSize(new Dimension(width,height));
		setLayout(new GridLayout(rows,cols,4,4));
		setBorder(new EmptyBorder(0,20,0,20));
		//arrLabels[][] = new JLabel[rows][cols];
		
		for (int row=0; row<rows; row++) {
			for (int col=0; col<cols; col++) {
				arrLabels[row][col] = new JLabel("1", SwingConstants.CENTER);
				arrLabels[row][col].setBackground(java.awt.Color.LIGHT_GRAY);
				arrLabels[row][col].setOpaque(true);
				add(arrLabels[row][col]);
			}
		}
	}
	
	public void setArrLabel(int row, int col, int val) {
		this.arrLabels[row][col].setText(""+val);
	}
}
