package mainFiles;

import javax.swing.SwingUtilities;

import controllers.Test1UIController;
import resources.Array7x7;
import testFiles.Test1UI;

public class StartTest1UI {

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
}

