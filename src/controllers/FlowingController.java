package controllers;

import java.util.Timer;
import java.util.TimerTask;

import resources.Array7x7;
import resources.Chars;
import resources.FlowingText;

public class FlowingController {
	Array7x7 array;
	FlowingText flowingText;
	private Timer timer = new Timer ();
	private TimerTask task;
	private String text;

	public FlowingController(Array7x7 array, FlowingText flowingText) {
		super();
		this.array = array;
		this.flowingText = flowingText;
		this.flowingText.setController(this);
	}
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

	public void blink(String text, int delay) {
		task = new TimerTask() {
			int counter = 0; 

			@Override
			public void run() {
				if (counter <text.length()) {
					printText(text.charAt(counter));
					counter++;
				} else {
					counter = 0;
					cancel();
				}
			}
		};

		timer.schedule(task, text.length(), delay);
	}
	
	public void disableButtons() {
		flowingText.disableButtons();
	}
	
	public void enableButtons() {
		flowingText.enableButtons();
	}

	public void scrollLeft(String text, int direction, int delay) {
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

	public void shiftLeft(int counter, int charCounter) {
		int test = 34;
		for(int i = 0; i <5; i++ ) {
			for(int j = 0; j <7; j++ ) {
				flowingText.printCol(Chars.getChar(text.charAt(i)).getCol(j), test);
				test--;
			}
		}
	}
	public void printText(char c) {
		printChar(Chars.getChar(c));
	}


}
