package controllers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import resources.Array7x7;
import resources.FontCreator7x7;
import testFiles.Test1UI;

public class FontController {
	private FontCreator7x7 fontCreator;
	private Array7x7 array;

	public FontController(FontCreator7x7 fontCreator, Array7x7 array) {
		super();
		this.fontCreator = fontCreator;
		this.array = array;	
		this.fontCreator.setController(this);

	}

	public void clickedOn(int row, int col) {
		fontCreator.clickedOn(row, col);
		if(array.getElement(row, col) == 1) {
			array.setElement(row, col, 0);
		}else {
			array.setElement(row, col, 1);
		}
	}

	public void toText(String s) throws FileNotFoundException, UnsupportedEncodingException {
		String string = "private static int[][] char"+s+" = {\r\n";
		for (int row=0; row<7; row++) {
			string +="{" +this.array.getElement(row, 0);
			for (int col=1; col<7; col++) {
				string +=","+this.array.getElement(row, col);
			}
			string+="}";
			if(row != 6) {
				string+=",\r\n";
			}
		}
		string+="};\r\n";
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("c:\\output.txt", true)));
			out.println(string);
		}catch (IOException e) {
			System.err.println(e);
		}finally{
			if(out != null){
				out.close();
			}
		} 
		toTextInverted(s);
	}
	
	public void toTextInverted(String s) throws FileNotFoundException, UnsupportedEncodingException {
		String string = "private static int[][] char"+s+"Inverted = {\r\n";
		for (int row=0; row<7; row++) {
			if(this.array.getElement(row, 0) == 1) {
				string+="0";
			}else {
				string +="1";
			}
			for (int col=1; col<7; col++) {
				string +=",";
				if(this.array.getElement(row, col) == 1) {
					string+="0";
				}else {
					string +="1";
				}
			}
			string+="}";
			if(row != 6) {
				string+=",\r\n";
			}
		}
		string+="};\r\n";
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("c:\\output.txt", true)));
			out.println(string);
		}catch (IOException e) {
			System.err.println(e);
		}finally{
			if(out != null){
				out.close();
			}
		} 
	}


}
