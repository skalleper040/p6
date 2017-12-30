package mainFiles;

import javax.swing.SwingUtilities;

import controllers.FlowingController;
import resources.Array7x7;
import resources.FlowingText;

/**
 *  The startfile for the amazing flowingtext program
 * @author Johannes Roos, Angelina Fransson, Sven Lindqvist
 *
 */
public class StartFlowing {
	public static void main(String[] args) {
	Array7x7 a771 = new Array7x7();


		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FlowingText ft = new FlowingText();
				FlowingController fc = new FlowingController(a771, ft);
			}
		});
	}
}

