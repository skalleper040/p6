package p6;

public class Array7x7 {
	private Array7[] elements;

	public Array7x7() {
		elements = new Array7[7];
		for(int i=0; i<elements.length; i++){
			elements[i]=new Array7();
		}
	}

	public Array7x7(Array7x7 array7x7) {
		elements = new Array7[7];
		for (int i = 0; i < elements.length; i++) {
			elements[i]=new Array7(array7x7.getRow(i));
		}
	}

	public Array7x7(int[][] array) {
		elements = new Array7[7];
		for (int row = 0; row < array.length; row++) {
			elements[row]=new Array7();
			for (int col = 0; col < array[row].length; col++) {
				elements[row].setElement(col, array[row][col]);
			}
		}
	}

	public void setElement(int row, int col, int value) {
		elements[row].setElement(col, value);
	}

	public int getElement(int row, int col) {
		return elements[row].getElement(col);
	}

	public void setRow(int row, Array7 theRow) {
		elements[row].setArray(theRow);
	}

	public Array7 getRow(int row) {
		return elements[row].getArray();
	}

	public void setCol(int col, Array7 theCol) {
		for (int i = 0; i < elements.length; i++) {
			elements[i].setElement(col, theCol.getElement(i));
		}
	}

	public Array7 getCol(int col) {
		Array7 result = new Array7();
		for (int i = 0; i < elements.length; i++) {
			result.setElement(i, elements[i].getElement(col));
		}
		return result;
	}

	public void setArray(Array7x7 array7x7) {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = array7x7.getRow(i);
		}
	}

	public void setArray(int[][] array) {
		int[] arr = new int[7];
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				arr[col] = array[row][col];
			}
			elements[row] = new Array7(arr);
		}
	}

	public Array7x7 getArray() {
		return new Array7x7(this);
	}

	public int[][] toIntArray() {
		int[][] result = new int[7][7];
		for (int row = 0; row < result.length; row++) {
			for (int col = 0; col < result[row].length; col++) {
				result[row][col] = elements[row].getElement(col);
			}
		}
		return result;
	}

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
