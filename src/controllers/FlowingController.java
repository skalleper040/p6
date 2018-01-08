package controllers;

import java.util.Timer;
import java.util.TimerTask;

import p6.Color;
import resources.Array7;
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
	private Array7x7 array;
	private FlowingText flowingText;
	private Timer timer = new Timer ();
	private TimerTask task;
	private String text;
	private Array7x7[] lettersArray;
	/**
	 * Takes an empty Array7x7 and an FlowingText instance. Calls setController()
	 * in FlowingText to set its controller to this controller.
	 * @param array	Array7x7 array, only used once
	 * @param flowingText FlowingText-object
	 */
	public FlowingController(Array7x7 array, FlowingText flowingText) {
		super();
		this.array = array;
		this.flowingText = flowingText;
		this.flowingText.setController(this);
	}
	
	/**
	 * Recives a string that shall be printed
	 * @param text String, the text that should blink
	 * @param delay int, the delay between blinks
	 */
	public void blink(String text, int delay) {
		flowingText.clearDisplay();
		lettersArray = new Array7x7[text.length()];
		for(int i = 0; i < text.length(); i++) {
			lettersArray[i] = new Array7x7(Chars.getChar(text.charAt(i)));
			lettersArray[i] = toColorArray(lettersArray[i]);
		}
		
		this.task = new TimerTask() {
			int counter = 0; 
			@Override
			public void run() {
				if(counter < text.length()) {
					flowingText.setDisplay(lettersArray[counter].toIntArray());
					counter++;
				}	
			}
		};
		timer.schedule(this.task, text.length(), delay);
	}
	/**
	 * Ends the timer and enables button.
	 */
	
	public void stop() {
		this.task.cancel();
		flowingText.enableButtons();
	}
	
	
	/**
	 * Shifts an array of Array7x7 objects one colum to the right.
	 * @param arr The array of Array7x7 object to be shifted right.
	 */
	public void shiftRight(Array7x7[] arr) {
		Array7 temp = arr[arr.length-1].getCol(6);
		
		for(int i = 0; i< arr.length;i++) {
			arr[i].shiftHorizontal('r', temp);
			temp=arr[i].getFarRight();
		}
	}
	/**
	 * Shifts an array of Array7x7 objects one colum to the left.
	 * @param arr The array of Array7x7 object to be shifted left.
	 */
	public void shiftLeft(Array7x7[] arr) {
		Array7 temp = arr[0].getCol(0);
		
		for(int i  = arr.length-1; i >= 0; i--) {
			arr[i].shiftHorizontal('l', temp);
			temp = arr[i].getFarLeft();
		}
	}
	/**
	 * Translates int values from an Array7x7 into colors to form characters.
	 * @param colors The Array7x7 object to be translated into characters.
	 * @return colors An Array7x7 object with color values, forming a character.
	 */
	public Array7x7 toColorArray(Array7x7 colors) {
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				if(colors.getElement(row, col) == 1) {
					colors.setElement(row, col, Color.MAGENTA);
				}
			}
		}
		return colors;
	}
	/**
	 * Takes a String object and reverses it.
	 * @param words The String to be reversed.
	 * @return str The reversed String.
	 */
	public String reverseString(String words) {
		String str = "";
		for(int i = words.length()-1; i >=0; i--) {
			str += words.charAt(i);
		}
		return str;
	}
	/**
	 * Receives a String and translates it into characters in color to be displayed in the
	 * monitor in various directions and speed based on user choice. Until user press "Stop" 
	 * the "Run" button is disabled.
	 * @param text string, the text
	 * @param direction int, direction, 1 - left, 2 - right, 3 - mirrored from left
	 * @param delay int, the delay between moves
	 */
	public void scroll(String text, int delay, int direction) {
		flowingText.disableButtons();
		if(direction ==2) {
			text = reverseString(text);
		}
		text = "     " + text;
		lettersArray = new Array7x7[text.length()];
		for(int i = 0; i < text.length(); i++) {
			lettersArray[i] = new Array7x7(Chars.getChar(text.charAt(i)));
			lettersArray[i] = toColorArray(lettersArray[i]);
		}
		
		task = new TimerTask() {
			int counter = 0; 

			@Override
			public void run() {
				for(int i = 0; i<5; i++) {
					flowingText.setDisplay(lettersArray[i].toIntArray(), 0,i);
				}
				if(direction == 1) {
				shiftLeft(lettersArray);
				} else if(direction == 2) {
					shiftRight(lettersArray);
				}
			}
		};

		timer.schedule(task, text.length(), delay);
	}
}
