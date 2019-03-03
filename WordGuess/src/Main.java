import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		WordGuessGame game = new WordGuessGame("src/words_alpha.txt");
		String input;
		game.selectWord();
		
		while(game.getRemainingGuesses() != 0) {
			game.displayWord();
			System.out.println("You have " + game.getRemainingGuesses() + " incorrect guess(es) remaining.");
			System.out.print("Guess a letter: ");
			input = reader.next();
			System.out.println("");
			if(game.checkInput(input)==true) {
				game.displayWord();
				System.out.println("Congratulations, you got it!");
				System.exit(0);
			};
		}
		System.out.print("Sorry, you're out of guesses! The answer was: " + game.getSolution());
	}
	
	
}
