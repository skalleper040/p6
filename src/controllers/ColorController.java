package controllers;

import java.util.Random;
import p6.*;
import resources.*;
import testFiles.*;
import java.util.*;
import javax.swing.*;

import controllers.ColorController;
import p6.Color;
import resources.Array7;
import resources.Array7x7;
import testFiles.TestColor;

/**
 * Controller skapad för att implementera Color-klassen i ColorDisplay
 * Kontrollerar vad som händer när man klickar på olika knappar
 * @author Carin Liljequist
 *
 */

public class ColorController {
	private Random random = new Random();
	private TestColor testcolor;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;

	/**
	 * Konstruktor vilken tar en klassen TestColor och Array7x7 som parametrar
	 * @param testcolor refererar till den ui som används
	 * @param array refererar till det Array7x7-objekt som ska användas
	 */
	public ColorController(TestColor testcolor, Array7x7 array) {
		this.testcolor = testcolor;
		this.array = array;
		// Sparar undan arrayen längst till höger i 7x7-objektet och lagrar det i variabeln rightColumn av typen Array7
		this.rightColumn = array.getCol(6); 
		// Sparar undan arrayen längst till vänster i 7x7-objektet och lagrar det i variabeln leftColumn av typen Array7
		this.leftColumn = array.getCol(0); 
		// går igenom rad (i) för rad vad som sparats i variabeln rightColumn
		for (int i = 0; i < 7; i++) {
			testcolor.setColTextField('r', i, this.rightColumn.getElement(i));
		}
		for (int i = 0; i < 7; i++) {
			testcolor.setColTextField('l', i, this.leftColumn.getElement(i));
		}
		testcolor.setColorController(this);
	//	showArray();
	}

	/**
	 * Uppdaterar JLabels med ColorDisplay
	 */
	public void showArray() {
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				testcolor.setArrLabels(row, col, array.getElement(row, col));
			}
		}
		testcolor.updateColorDisplay(this.array);
		testcolor.updateDisplay();
	}

	/**
	 * Flyttar columner i 7x7 displayen, höger eller vänster
	 * @param direction riktningen som columnerna flyttas
	 * @param shiftIn tilldelar columnerna, col = 0 eller col = 6, med ny Array7
	 * @param shiftOut sparar columnen som flyttas ut från 7x7 displayen
	 */
	public Array7 shiftHorizontal(char direction, Array7 shiftIn) {
		Array7 shiftOut = null;
		if (direction == 'r') {
			// Flyttar columnen till höger och sparar columnen i variable shiftOut 
			shiftOut = array.getCol(6);
			// Flyttar column för column med start från höger 
			for (int i = 5; i >= 0; i--) {
				array.setCol(i + 1, array.getCol(i));
			}
			// Flyttar in coumnen från parameter shiftIn
			array.setCol(0, shiftIn);
		} else if (direction == 'l') {
			shiftOut = array.getCol(0);
			for (int i = 1; i <= 6; i++) {
				array.setCol(i - 1, array.getCol(i));
			}
			array.setCol(6, shiftIn);
		}
		// Returnerar columnen som flyttas ut från 7x7 displayen
		return shiftOut;
	}

	/**
	 * Randomiserar en ny färg för columnen längst till höger eller vänster
	 * och flytta in columnen längst till väntsre och höger in i 7x7 displayen
	 * @param direction riktningen som columnerna flyttas
	 */
	public void shiftInCol(char direction) {
		int randColor[] = new int[7];
		for (int i = 0; i < 7; i++) {
			randColor[i] = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		}
		Array7 shiftIn = null;
		if (direction == 'r') {
			shiftIn = this.testcolor.getCol('l');
			this.testcolor.setCol('l', new Array7(randColor));
		} else if (direction == 'l') {
			shiftIn = this.testcolor.getCol('r');
			this.testcolor.setCol('r', new Array7(randColor));
		}
		// Utför flyttoperationen och sparar columnen som flyttas ut 
		Array7 shiftOut = this.shiftHorizontal(direction, shiftIn);
		this.testcolor.setCol(direction, shiftOut);
		showArray();
	}
	
	/**
	 * Testar color implementation genom att randomly byta plats på två pixlar
	 */
	public void randomSwap() {
		int colA = random.nextInt(6);
		int colB = random.nextInt(6);
		int rowA = random.nextInt(6);
		int rowB = random.nextInt(6);
		int tmp = array.getElement(rowA, colA);
		array.setElement(rowA, colA, array.getElement(rowB, colB));
		array.setElement(rowB, colB, tmp);
		showArray();
	}

	/**
	 * Testar color implementation genom att byta plats på två pixlar
	 */
	public void twoCellsSwap() {
		int rowA = 0;
		int colA = 0;
		int rowB = 6;
		int colB = 6;
		int tmp = array.getElement(rowA, colA);
		array.setElement(rowA, colA, array.getElement(rowB, colB));
		array.setElement(rowB, colB, tmp);
		showArray();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TestColor testcolor = new TestColor();
				int[][] arrayColor = {
						{ 0xFF004300, 0x23832892, 0x41923700, 0xFFFFFFFF, 0x43738292, 0xFF881100, 0x88FF6624 },
						{ 0xFF330024, 0x27930493, 0xFF00FF00, 0x33FFFF49, 0x52FFEE24, 0x22281100, 0x82003918 },
						{ 0x88203672, 0x83920028, 0xFF002700, 0xFFFFFFFF, 0x09271953, 0x81272233, 0x62026624 },
						{ 0xFF558800, 0x27008645, 0x0394FF00, 0xFF00FFFF, 0x99FF8322, 0x02921100, 0xFF662499 },
						{ 0x2700FF00, 0x292200FF, 0x32839300, 0x00223793, 0xFF247303, 0xFF721127, 0x51729924 },
						{ 0xFF0000FF, 0x03002529, 0x88273300, 0xFF2176FF, 0x43847238, 0x88FF1100, 0x97FF6624 },
						{ 0x77FF0023, 0x870026FF, 0x82937600, 0x93FF29FF, 0x04839402, 0x82361100, 0x00926709 } };
				Array7x7 array = new Array7x7(arrayColor);
				ColorController colcontroller = new ColorController(testcolor, array);
				testcolor.updateColorDisplay(array);
				testcolor.updateDisplay();
			}
		});
	}
}