package controllers;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import resources.Array7;
import resources.Array7x7;
import testFiles.Test1UI;

/**
 * Controller to the Test1UI class
 * 
 * @author Johannes, Angelina
 *
 */
public class Test1UIController {
	private Test1UI test1ui;
	private Array7x7 array;
	private Array7 leftColum;
	private Array7 bottomRow;
	
	/**
	 * Constructor 
	 * @param test1ui	Test1UI object
	 * @param array		7x7 Array
	 */
	public Test1UIController(Test1UI test1ui, Array7x7 array) {
		this.test1ui = test1ui;
		this.array = array;
		
		this.test1ui.setController(this);
		showArray();
	}
	
	/**
	 * Read-method, called in the Test1UI-class. 
	 * Input as a boolean, True for bottom row, false for leftColum
	 * @param row
	 */
	public void read(boolean row) {
		if(row) {
			if(1<= test1ui.getRowNbr() && test1ui.getRowNbr() <=7) {

				bottomRow = array.getRow(test1ui.getRowNbr()-1);
				test1ui.setBotRow(bottomRow);	
			}else {
				JOptionPane.showMessageDialog(null,"Fel");
			}
		}else {
			if(1<= test1ui.getColNbr() && test1ui.getColNbr() <=7) {
				leftColum = array.getCol(test1ui.getColNbr()-1);
				test1ui.setLeftCol(leftColum);
			}else {
				JOptionPane.showMessageDialog(null,"Fel");
			}
		}
	}
	
	/**
	 * Write-method, called in the Test1UI-class. 
	 * Input as a boolean, True for bottom row, false for leftColum
	 * @param row
	 */
	public void write(boolean row) {
		if(row) {
			if(1 <= test1ui.getRowNbr() && test1ui.getRowNbr() <=7) {
				array.setRow(test1ui.getRowNbr()-1, test1ui.getBotRow());
			}else {
				JOptionPane.showMessageDialog(null,"Fel");
			}
			
		}else {
			if(1 <= test1ui.getColNbr() && test1ui.getColNbr() <=7) {
				array.setCol(test1ui.getColNbr()-1, test1ui.getLeftCol());
			}else {
				JOptionPane.showMessageDialog(null,"Fel");
			}
			
		}
		
		showArray();
	}
	
	/**
	 * Printing the complete array
	 * 
	 */
	public void showArray() {
		for (int row=0; row<7; row++) {
			for (int col=0; col<7; col++) {
				test1ui.setArrLabels(row, col, array.getElement(row, col));
			}
		}
	}
	


	public void setUserInput(Test1UI test1ui) {
		this.test1ui = test1ui;
		
	}
	
	
}
