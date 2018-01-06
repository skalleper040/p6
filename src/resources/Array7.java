package resources;

/**
 * Klassen Array7 reprsenterar en array med 7 int-element
 * @author Loise Borg
 *
 */
public class Array7 {
	private int[] elements;

	/**
	 * Konstruerar ett array-objekt med 7 element där alla värden är 0 
	 */
	public Array7() {
		elements = new int[7];
	}

	/** 
	 * Konstruerer ett array-objekt med angivna värden
	 * @param array7 en array med 7 element 
	 */
	public Array7(Array7 array7) {
		elements = new int[7];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = array7.getElement(i);
		}

	}

	/**
	 * Konstruerar ett array-objekt med angivna värden
	 * @param array en array
	 */
	public Array7(int[] array) {
		elements = new int[7];
		for (int i = 0; i < array.length; i++)
			elements[i] = array[i];
	}

	/**
	 * Sätter värdet på ett element
	 * @param pos elementets position
	 * @param value värde som angivet element ska få
	 */
	public void setElement(int pos, int value) {
		elements[pos] = value;
	}

	/**
	 * Returnerar värdet på ett element
	 * @param pos elementets position
	 * @return värdet på angivet element
	 */
	public int getElement(int pos) {
		return elements[pos];
	}

	
	/**
	 * Sätter värdet på alla element
	 * @param array7 array med 7 element
	 */
	public void setArray(Array7 array7) {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = array7.getElement(i);
		}
	}

	/**
	 * Sätter värdet på alla element
	 * @param array 
	 */
	public void setArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			elements[i] = array[i];
	}

	/**
	 * Returnerar en kopia av aktuell objekt
	 * @return 
	 */
	public Array7 getArray() {
		return new Array7(this);
	}

	/**
	 * Returnerar en int-array med lika värden som aktuellt objekt
	 * @return int-array med 7 element
	 */
	public int[] toIntArray() {
		int[] result = new int[7];
		for (int i = 0; i < result.length; i++) {
			result[i] = elements[i];
		}
		return result;
	}

	/**
	 * Skriver ut alla element i aktuellt objekt
	 * @return sträng med alla element utskrivna
	 */
	public String toString() {
		String result = "";

		for (int i = 0; i < elements.length; i++) {
			result += elements[i] + " ";
		}
		result += "\n";
		return result;
	}
}
