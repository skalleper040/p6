package p6;

public class Test {
	public static void main(String[] args) {
		int[] arr1 = { 4, 5, 2, 6, 1, 2, 7 };
		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };

		Array7 a71 = new Array7();
		Array7 a72 = new Array7(arr1);
		Array7 a73 = new Array7(a72);
		Array7 a74 = new Array7();
		Array7 a75 = new Array7();
		Array7 a76 = new Array7(a75.getArray());

		System.out.println("a71: " + a71);
		System.out.println("a72: " + a72);
		System.out.println("a73: " + a73);
		System.out.println("a74: " + a74);
		System.out.println("a75: " + a75);
		System.out.println("a76: " + a76); 
		
		a71.setElement(3, 4);
		a74.setArray(arr2);
		a75.setArray(a72);
		

		int[] arr3 = a71.toIntArray();

		System.out.println("a71: " + a71);
		System.out.println("a74: " + a74);
		System.out.println("a75: " + a75);
		

		System.out.print("arr3: ");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();

		int[][] mat1 = { { 1, 2, 3, 4, 5, 6, 7 }, { 2, 2, 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3, 3, 3 },
				{ 4, 4, 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5, 5, 5 }, { 6, 6, 6, 6, 6, 6, 6 }, { 7, 7, 7, 7, 7, 7, 7 } };
		Array7x7 a771 = new Array7x7();
		Array7x7 a772 = new Array7x7(mat1);
		Array7x7 a773 = new Array7x7(a771);

		System.out.println("a771:\n" + a771 + "\n");
		System.out.println("a772:\n" + a772 + "\n");
		System.out.println("a773: \n" + a773 + "\n");
		
		a771.setElement(4, 6, a772.getElement(4, 6));
		a773.setArray(a772);
		
		System.out.println("a771:\n" + a771 + "\n");
		System.out.println("a773: \n" + a773 + "\n");
		
		a771.setCol(0, a773.getCol(0));
		a771.setRow(6, a773.getRow(6));

		System.out.println("a771:\n" + a771 + "\n");
		System.out.println();
		
		a771.shiftHorizontal('l');
		
		System.out.println("a771:\n" + a771 + "\n");
		
		
		
		
	}

}
