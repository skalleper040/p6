package mainFiles;

import javax.swing.SwingUtilities;
import controllers.*;
import resources.*;
import testFiles.*;


/**
 * Test med mainmetod för moment 3, uppgift 5.
 * @author Oscar
 *
 */

public class StartTest2UI {
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
				Test2UI t2 = new Test2UI();
				IntController controller = new IntController(t2, a772);
			}
		});
	}
}
