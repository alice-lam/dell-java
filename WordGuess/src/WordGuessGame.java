import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WordGuessGame {
	private char[] solutionWord;
	private List<String> dictionary = new ArrayList();
	private int remainingGuesses = 6;
	String[] currentBoard;
	
	// constructor to read words in the file to the objects
	public WordGuessGame(String filePath) {
		readToStorage(filePath);
	}

	// reads and stores all the words in the given file
	private void readToStorage(String filePath) {
		String line;

		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			while ((line = in.readLine()) != null) {
				dictionary.add(line.toUpperCase());
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//selects random number and grabs that word from dictionary
	public void selectWord() {
		Random r = new Random();
		int randomNum = r.nextInt(dictionary.size());
		String word = (String)dictionary.get(randomNum);
		solutionWord = word.toCharArray();
		currentBoard = new String[solutionWord.length];
		for (int i= 0; i<currentBoard.length; i++) {
			currentBoard[i] = "_";
		}
	}
	
	//prints out the current board of words
	public void displayWord() {
		boolean nullpass = true;
		for(String i : currentBoard) {
			System.out.print(i+" ");
		}
		System.out.println("");
	}
	
	//checks input to see if user got a correct letter and if board is completed
	public boolean checkInput(String input) {
		boolean noNull = true;
		boolean correctGuess = false;
		
		for(int i=0; i<solutionWord.length; i++) {
			String letter = Character.toString(solutionWord[i]);
			if(input.equalsIgnoreCase(letter)) {
				currentBoard[i] = letter;
				correctGuess = true;
			}
			if(currentBoard[i].equals("_")) {
				noNull = false;
			}
		}
		if(correctGuess==false) {remainingGuesses --;}
		return noNull;
	}
	
	//gets number of incorrect guesses remaining
	public int getRemainingGuesses() {
		return this.remainingGuesses;
	}
	
	//gets correct solution word
	public String getSolution() {
		return new String(solutionWord);
	}
	
}