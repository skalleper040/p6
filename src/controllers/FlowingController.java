package controllers;

import resources.Array7x7;
import resources.Chars;
import resources.FlowingText;

public class FlowingController {
	Array7x7 array;
	FlowingText flowingText;
	
	public FlowingController(Array7x7 array, FlowingText flowingText) {
		super();
		this.array = array;
		this.flowingText = flowingText;
		this.flowingText.setController(this);
	}
	public void printChar (Array7x7 arr) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				flowingText.printSquare(arr, i, j);	
			}
		}
	}
	
	public void printText(String text) {
		for(int i = 0; i < text.length();i++) {
			printChar(Chars.getChar(text.charAt(i)));
			
			//System.out.println(text.substring(i, i+1));
		}
		
		
	}
	

}
