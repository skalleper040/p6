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
	private JLabel arrLabels[][] = new JLabel[7][7];

	public FlowingArrayPanel() {
		setPreferredSize(new Dimension(400,400));
		setLayout(new GridLayout(7,7,1,1));
		setBorder(new EmptyBorder(0,0,0,0));


		for (int row=0; row<7; row++) {
			for (int col=0; col<7; col++) {
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

}
