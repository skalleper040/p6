package controllers;

import javax.swing.SwingUtilities;

import resources.Array7;
import resources.Array7x7;
import testFiles.Test1UI;

public class Test1UIController {
	private Test1UI test1ui;
	private Array7x7 array;
	private Array7 leftColum;
	private Array7 bottomRow;
	
	public Test1UIController(Test1UI test1ui, Array7x7 array) {
		this.test1ui = test1ui;
		this.array = array;
		
		this.test1ui.setController(this);
		showArray();
	}
	
	public void read(boolean row) {
		if(row) {
			bottomRow = array.getRow(test1ui.getRowNbr()-1);
			test1ui.setBotRow(bottomRow);
		}else {
			leftColum = array.getCol(test1ui.getColNbr()-1);
			test1ui.setLeftCol(leftColum);
		}
	}
	
	public void write(boolean row) {
		if(row) {
			array.setRow(test1ui.getRowNbr()-1, test1ui.getBotRow());
		}else {
			array.setCol(test1ui.getColNbr()-1, test1ui.getLeftCol());
		}
		
		showArray();
	}
	
	
	public void showArray() {
		for (int row=0; row<7; row++) {
			for (int col=0; col<7; col++) {
				test1ui.setArrLabels(row, col, array.getElement(row, col));
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] mat1 = { { 1, 2, 3, 4, 5, 6, 7 }, 
				{ 2, 3, 5, 1, 2, 5, 2 }, 
				{ 3, 3, 3, 3, 3, 3, 3 },
				{ 4, 5, 3, 4, 4, 4, 4 }, 
				{ 5, 7, 8, 5, 5, 5, 5 }, 
				{ 6, 6, 6, 2, 6, 6, 6 }, 
				{ 7, 3, 7, 1, 7, 6, 7 } };
		Array7x7 a771 = new Array7x7();
		Array7x7 a772 = new Array7x7(mat1);
		Array7x7 a773 = new Array7x7(a771);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Test1UI t2 = new Test1UI();
				Test1UIController controller = new Test1UIController(t2, a772);
			}
		});
	}

	public void setUserInput(Test1UI test1ui) {
		this.test1ui = test1ui;
		
	}
	
	
}
