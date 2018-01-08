package controllers;

import resources.Array7;
import resources.Array7x7;
import testFiles.Test2UI;


/**
 * Controller som används till moment 3
 * @author Oscar
 *
 */
public class IntController {
	
	private Test2UI ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;
	
	
	/**
	 * Konstruktor
	 * @param ui bestämmer vilket ui som används
	 * @param array bestämmer vilket Array7x7-objekt som ska användas
	 */
	
	public IntController(Test2UI ui, Array7x7 array) {
		this.ui = ui;
		this.array = array;
		this.rightColumn = array.getCol(6); // Sparar undan den sista arrayen i 7x7-objektet
		this.leftColumn = array.getCol(0); // Sparar undan den första arrayen 7x7-objektet

		// Sätter värdena ifrån rightColumn och leftColumn i textFields i UI
		for (int i = 0; i < 7; i++) {
			ui.setColTextField('r', i, this.rightColumn.getElement(i));
		}
		for (int i = 0; i < 7; i++) {
			ui.setColTextField('l', i, this.leftColumn.getElement(i));
		}
		ui.setController(this);
		showArray();
	}

	/**
	 * Uppdaterar JLabels i UI med rätt värde från given array
	 */
	public void showArray() {
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				ui.setArrLabels(row, col, array.getElement(row, col));
			}
		}
	}

	/**
	 * Skiftar innehållet till höger eller vänster.
	 * 
	 * @param direction
	 *            bestämmer riktninngen
	 */
	public void shiftHorizontal(char direction) {
		if (direction == 'r') {

			// Hämtar innehållet från textFälts-kolumnen i UI och sparar undand det.
			Array7 tmpLeftCol = ui.getCol('l');
			
			// Uppdaterar textfälts-kolumnen i UI med värdena från kolumnen längst till höger i arrayen
			for (int i = 0; i < 7; i++) {
				ui.setColTextField('r', i, array.getElement(i, 6));
			}
			
			// Flyttar innehållet i arrayen i sidled med anrop till Array7x7-objektet. De undansparade värdena från textfältskolumnen skickas som inaprameter
			array.shiftHorizontal('r', tmpLeftCol);
		}

		else if (direction == 'l') {
			
			// Hämtar innehållet från textFälts-kolumnen i UI och sparar undand det.
			Array7 tmpRightCol = ui.getCol('r');

			// Uppdaterar textfälts-kolumnen i UI med värdena från kolumnen längst till vänster i arrayen
			for (int i = 0; i < 7; i++) {
				ui.setColTextField('l', i, array.getElement(i, 0));
			}
			
			// Flyttar innehållet i arrayen i sidled med anrop till Array7x7-objektet. De undansparade värdena från textfältskolumnen skickas som inaprameter
			array.shiftHorizontal('l', tmpRightCol);
		}

		// Uppdatera den grafiska arrayen
		showArray();
	}
}
