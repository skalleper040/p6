package controllers;

import resources.Array7x7;
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
	
	public void printText(String text) {
		for(int i = 0; i < text.length();i++) {
			System.out.println(text.substring(i, i+1));
		}
	}
	

}
