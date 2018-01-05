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
	private Array7x7[] lettersArray;
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
	
	/**
	 * Recives a string that shall be printed
	 * @param text String, the text that should blink
	 * @param delay int, the delay between blinks
	 */
	public void blink(String text, int delay) {
		lettersArray = new Array7x7[text.length()];
		for(int i = 0; i < text.length(); i++) {
			lettersArray[i] = new Array7x7(Chars.getChar(text.charAt(i)));
			
		}
		
		task = new TimerTask() {
			int counter = 0; 

			@Override
			public void run() {
				if(counter < text.length()) {
					
					
					flowingText.setDisplay(lettersArray[counter].toIntArray());
					counter++;
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
	
	


}
