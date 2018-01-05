package controllers;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import p6.*;
import resources.*;
import testFiles.*;

public class Controller {
	private Timer timer;
	private Random random = new Random();
	private ColorDisplayDemo demo;
	private Test2UI ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;

	private int[][] charA = { { Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE },
			{ Color.BLUE, Color.BLUE, Color.WHITE, Color.BLUE, Color.WHITE, Color.BLUE, Color.BLUE },
			{ Color.BLUE, Color.BLUE, Color.WHITE, Color.BLUE, Color.WHITE, Color.BLUE, Color.BLUE },
			{ Color.BLUE, Color.BLUE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLUE, Color.BLUE },
			{ Color.BLUE, Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE, Color.BLUE },
			{ Color.BLUE, Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE, Color.BLUE },
			{ Color.BLUE, Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE, Color.BLUE } };
	private int[][] charR = {
			{ Color.TRANSPARENT, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.TRANSPARENT,
					Color.TRANSPARENT },
			{ Color.TRANSPARENT, Color.WHITE, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.WHITE,
					Color.TRANSPARENT },
			{ Color.TRANSPARENT, Color.WHITE, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.WHITE,
					Color.TRANSPARENT },
			{ Color.TRANSPARENT, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.TRANSPARENT,
					Color.TRANSPARENT },
			{ Color.TRANSPARENT, Color.WHITE, Color.TRANSPARENT, Color.WHITE, Color.TRANSPARENT, Color.TRANSPARENT,
					Color.TRANSPARENT },
			{ Color.TRANSPARENT, Color.WHITE, Color.TRANSPARENT, Color.TRANSPARENT, Color.WHITE, Color.TRANSPARENT,
					Color.TRANSPARENT },
			{ Color.TRANSPARENT, Color.WHITE, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.WHITE,
					Color.TRANSPARENT } };
	private int[][] stamp = new int[7][7];

	public Controller(ColorDisplayDemo demo) {
		this.demo = demo;
		demo.setController(this);
	}
	
	/**
	 * Konstruktor
	 * @param ui bestämmer vilket ui som används
	 * @param array bestämmer vilket Array7x7-objekt som ska användas
	 */
	public Controller(Test2UI ui, Array7x7 array) {
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
			
			Array7 tmpLeftCol = ui.getCol('l');
			for (int i = 0; i < 7; i++) {
				ui.setColTextField('r', i, array.getElement(i, 6));
			}
			array.shiftHorizontal('r', tmpLeftCol);

		}

		else if (direction == 'l') {
			
			Array7 tmpRightCol = ui.getCol('r');
			
			for (int i = 0; i < 7; i++) {
				ui.setColTextField('l', i, array.getElement(i, 0));
			}
			
			array.shiftHorizontal('l', tmpRightCol);
		}
		
		// Uppdatera den grafiska arrayen
		showArray();
	}

	private void show(int[][] arr) {
		for (int row = 0; row < stamp.length; row++) {
			for (int col = 0; col < stamp[row].length; col++) {
				stamp[row][col] = arr[row][col];
			}
		}
		demo.updateDisplay(stamp);
	}

	public void showA() {
		show(charA);
	}

	public void showR() {
		show(charR);
	}

	public void showRandom() {
		int red, green, blue;
		for (int row = 0; row < stamp.length; row++) {
			for (int col = 0; col < stamp[row].length; col++) {
				red = random.nextInt(256);
				green = random.nextInt(256);
				blue = random.nextInt(256);
				stamp[row][col] = Color.rgb(red, green, blue);
			}
		}
		demo.updateDisplay(stamp);
	}

	public void useTimer() {
		timer = new Timer();
		demo.enableButtons(false);
		timer.schedule(new RandomColors(), 500, 500);

	}

	public void fadeOut() {
		timer = new Timer();
		demo.enableButtons(false);
		timer.schedule(new FadeOut(), 20, 20);
	}

	private void transparency() {
		int alpha, red, green, blue;
		for (int row = 0; row < stamp.length; row++) {
			for (int col = 0; col < stamp[row].length; col++) {

				alpha = Color.alpha(stamp[row][col]);
				if (alpha > 0)
					alpha--;
				red = Color.red(stamp[row][col]);
				green = Color.green(stamp[row][col]);
				blue = Color.blue(stamp[row][col]);
				stamp[row][col] = Color.argb(alpha, red, green, blue);
			}
		}
		demo.updateDisplay(stamp);
	}

	private class RandomColors extends TimerTask {
		private int counter = 0;

		public void run() {
			if (counter < 10) {
				counter++;
				showRandom();
			} else {
				timer.cancel(); // Can't use Timer-instance anymore
				demo.enableButtons(true);
			}
		}
	}

	private class FadeOut extends TimerTask {
		private int counter = 255;

		public void run() {
			if (counter >= 0) {
				transparency();
				counter--;
			} else {
				timer.cancel();
				demo.enableButtons(true);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ColorDisplayDemo demo = new ColorDisplayDemo(Color.BLACK, Color.GRAY);
				new Controller(demo);
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(demo);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
