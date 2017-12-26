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

			// Sparar undan innehållet som finns i textfieldsen just nu
			Array7 tmpLeftColumn = this.ui.getCol('l');
			
			// Lägger sista kolumnen i array7x7 i arrayen rightColumn
			this.rightColumn = this.array.getCol(array.toIntArray().length - 1);
			
			// Lägg in värdena i rightColumn i textFieldsen. Dvs det som "faller över kanten".
			for (int i = 0; i < this.rightColumn.toIntArray().length; i++) {
				ui.setColTextField('r', i, this.rightColumn.getElement(i));
			}
			
			// Flytta kolumn för kolumn ett steg åt höger. Går bakifrån. 'i' reprsenterar kolumnen som ska flyttas och den flyttas sedan till i+1.
			for (int i = array.toIntArray().length - 2; i >= 0; i--) {
				Array7 colToBeMoved = this.array.getCol(i);
				this.array.setCol(i + 1, colToBeMoved);
			}
			
			// Lägg in de undansparade värdena från textfieldsen till den första kolumnen i array7x7
			this.array.setCol(0, tmpLeftColumn);
		}

		else if (direction == 'l') {

			Array7 tmpRightColumn = this.ui.getCol('r');
			this.leftColumn = this.array.getCol(0);
			for (int i = 0; i < 7; i++) {
				ui.setColTextField('l', i, this.leftColumn.getElement(i));
			}

			for (int i = 1; i <= array.toIntArray().length-1; i++) {
				Array7 colToBeMoved = this.array.getCol(i);
				this.array.setCol(i - 1, colToBeMoved);
			}

			this.array.setCol(array.toIntArray().length-1, tmpRightColumn);
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
