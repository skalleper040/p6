package p6;

public class Array7 {
	private int[] elements;

	public Array7() {
		elements = new int[7];
	}

	public Array7(Array7 array7) {
		elements = new int[7];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = array7.getElement(i);
		}

	}

	public Array7(int[] array) {
		elements = new int[7];
		for (int i = 0; i < array.length; i++)
			elements[i] = array[i];
	}

	public void setElement(int pos, int value) {
		elements[pos] = value;
	}

	public int getElement(int pos) {
		return elements[pos];
	}

	public void setArray(Array7 array7) {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = array7.getElement(i);
		}
	}

	public void setArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			elements[i] = array[i];
	}

	public Array7 getArray() {
		return new Array7(this);
	}

	public int[] toIntArray() {
		int[] result = new int[7];
		for (int i = 0; i < result.length; i++) {
			result[i] = elements[i];
		}
		return result;
	}

	public String toString() {
		String result = "";

		for (int i = 0; i < elements.length; i++) {
			result += elements[i] + " ";
		}
		result += "\n";
		return result;
	}
}
