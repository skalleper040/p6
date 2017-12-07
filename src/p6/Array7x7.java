package p6;

/**
 * Klassen representerar en array innehållandes 7 st Array7-objekt/en 2d-array med 7x7 värden
 * @author Loise Borg
 *
 */
public class Array7x7 {
	private Array7[] elements;

	/**
	 * Konstruerar en array med 7 array7-objekt
	 */
	public Array7x7() {
		elements = new Array7[7];
		for(int i=0; i<elements.length; i++){
			elements[i]=new Array7();
		}
	}

	/** 
	 * Konstruerar ett array-objekt med angivna värden
	 * @param array7x7 en array med 7x7 element
	 */
	public Array7x7(Array7x7 array7x7) {
		elements = new Array7[7];
		for (int i = 0; i < elements.length; i++) {
			elements[i]=new Array7(array7x7.getRow(i));
		}
	}

	/** 
	 * Konsturerar ett array-objekt med angivna värden
	 * @param array en 2d-array
	 */
	public Array7x7(int[][] array) {
		elements = new Array7[7];
		for (int row = 0; row < array.length; row++) {
			elements[row]=new Array7();
			for (int col = 0; col < array[row].length; col++) {
				elements[row].setElement(col, array[row][col]); //anropar setElement() i Array7
			}
		}
	}

	/**
	 * Sätter värdet på ett element
	 * @param row den rad elementet är på
	 * @param col elementets position
	 * @param value värde som angivet element ska få
	 */
	public void setElement(int row, int col, int value) {
		elements[row].setElement(col, value); //anropar setElement() i Array7
	}

	
	/**
	 * Returnerar värdet på ett element
	 * @param row den rad elementet är på
	 * @param col elementets position
	 * @return värdet på angivet element
	 */
	public int getElement(int row, int col) {
		return elements[row].getElement(col); //anropar getElement() i Array7
	}

	
	/**
	 * Sätter värden på alla element i en rad
	 * @param row den rad som ska sättas
	 * @param theRow värdena som angiven rad ska få
	 */
	public void setRow(int row, Array7 theRow) {
		elements[row].setArray(theRow); //anropar setArray() i Array7
	}

	/**
	 * Returnerar värdena på alla element i en rad
	 * @param row den rad som ska returneras
	 * @return ett Array7-objekt innehållandes värdena i raden
	 */
	public Array7 getRow(int row) {
		return elements[row].getArray(); //anropar getArray() i Array7
	}

	/**
	 * Sätter värden på alla element i en kolumn
	 * @param col den kolumn som ska sättas
	 * @param theCol värdena som angiven kolumn ska få
	 */
	public void setCol(int col, Array7 theCol) {
		for (int i = 0; i < elements.length; i++) { 
			elements[i].setElement(col, theCol.getElement(i)); //anropar setElement() i Array7
		}
	}

	/**
	 * Returnerar värdena på alla element i en kolumn
	 * @param col den kolumn som ska returneras
	 * @return ett Array7-objekt innehållandes värdena i kolumnen
	 */
	public Array7 getCol(int col) {
		Array7 result = new Array7();
		for (int i = 0; i < elements.length; i++) {
			result.setElement(i, elements[i].getElement(col)); //anropar getElement() i Array7
		}
		return result;
	}

	/**
	 * Sätter alla värden i objektet
	 * @param array7x7 array med 7 Array7-objekt
	 */
	public void setArray(Array7x7 array7x7) {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = array7x7.getRow(i);
		}
	}

	/**
	 * Sätter alla värden i objektet
	 * @param array en 2d-array
	 */
	public void setArray(int[][] array) {
		int[] arr = new int[7];
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				arr[col] = array[row][col];
			}
			elements[row] = new Array7(arr);
		}
	}

	/**
	 * Returnerar en kopia av aktuellt objekt
	 * @return 
	 */
	public Array7x7 getArray() {
		return new Array7x7(this);
	}

	/**
	 * Returnerar en 2d-array med lika värden som aktuellt objekt
	 * @return en 2d-array av typen int
	 */
	public int[][] toIntArray() {
		int[][] result = new int[7][7];
		for (int row = 0; row < result.length; row++) {
			for (int col = 0; col < result[row].length; col++) {
				result[row][col] = elements[row].getElement(col);
			}
		}
		return result;
	}

	/**
	 * Skriver ut alla element i aktuellt objekt
	 */
	public String toString() {
		String result = "";
		for (int row = 0; row < elements.length; row++) {
			for (int col = 0; col < elements.length; col++) {
				result += elements[row].getElement(col) + " ";
			}
			result+="\n";
		}
		result += "\n";

		return result;

	}
}
