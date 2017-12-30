package controllers;

import java.util.Timer;
import java.util.TimerTask;

import resources.Array7x7;
import resources.Chars;
import resources.FlowingText;

/**
 *  Controller made for the flowingtext-class
 *  Controlls what happends when buttons are clicked
 * @author Johannes Roos, Angelina Fransson, Sven Lindqvist
 *
 */
public class FlowingController {
	Array7x7 array;
	FlowingText flowingText;
	private Timer timer = new Timer ();
	private TimerTask task;
	private String text;

	/**
	 * 
	 * @param array	Array7x7 array, only used once
	 * @param flowingText FlowiingText-object
	 */
	public FlowingController(Array7x7 array, FlowingText flowingText) {
		super();
		this.array = array;
		this.flowingText = flowingText;
		this.flowingText.setController(this);
	}
	
	/**
	 * Loops through the incomming char and calls flowingtext.printSquare to print it
	 * @param arr Array7x7, a char
	 */
	public void printChar (Array7x7 arr) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if(arr.getElement(i, j) == 1) {
					flowingText.printSquareOn(i, j);	
				}else {
					flowingText.printSquareOff(i, j);	
				}

			}
		}
	}
	
	/**
	 * Recives a string that shall be printed
	 * @param text String, the text that should blink
	 * @param delay int, the delay between blinks
	 */
	public void blink(String text, int delay) {
		task = new TimerTask() {
			int counter = 0; 

			@Override
			public void run() {
				if (counter <text.length()) {
					printChar(Chars.getChar(text.charAt(counter)));
					counter++;
				} else {
					counter = 0;
					cancel();
				}
			}
		};

		timer.schedule(task, text.length(), delay);
	}
	
	/**
	 * Disables buttons in flowingText
	 */
	
	public void disableButtons() {
		flowingText.disableButtons();
	}
	
	/**
	 * Enables buttons in flowingText
	 */
	public void enableButtons() {
		flowingText.enableButtons();
	}

	/**
	 * Recives a string that shall scroll over the array
	 * Disables buttons during the scroll
	 * @param text string, the text
	 * @param direction int, direction, 1 - left, 2 - right, 3 - mirrored from left
	 * @param delay int, the delay between moves
	 */
	public void scroll(String text, int direction, int delay) {
		disableButtons();
		this.text = text;
		task = new TimerTask() {
			int counter = 0;
			int charCounter = -1;
			public void run() {
				if(counter%7 == 0) {
					counter = 0;
					charCounter++;
				}
				if(direction == 1) {
					flowingText.shiftLeft();
					if(charCounter < text.length()) {
						flowingText.printCol(Chars.getChar(text.charAt(charCounter)).getCol(counter),34);
					}
					
				}
				
				if(direction == 2) {
					flowingText.shiftRight();
					if(charCounter < text.length()) {
						flowingText.printCol(Chars.getChar(text.charAt(charCounter)).getCol(-(counter-6)),0);
					}
					
				}
				
				if(direction == 3) {
					flowingText.shiftRight();
					if(charCounter < text.length()) {
						flowingText.printCol(Chars.getChar(text.charAt(charCounter)).getCol(counter),0);
					}
					
				}
				
				counter++;
				if(charCounter == text.length()+5) {
					enableButtons();
					cancel();
					//charCounter = 0;
				}
			}
		};

		timer.purge();
		timer.schedule(task, 0, delay);
	}
	
	/**
	 * Shifts the entire array one step to the left
	 * @param counter int, the column in the current char
	 * @param charCounter int, the 
	 */
	public void shiftLeft(int counter, int charCounter) {
		int test = 34;
		for(int i = 0; i <5; i++ ) {
			for(int j = 0; j <7; j++ ) {
				flowingText.printCol(Chars.getChar(text.charAt(i)).getCol(j), test);
				test--;
			}
		}
	}



}
