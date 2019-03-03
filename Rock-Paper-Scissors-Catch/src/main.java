import java.util.Random;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		System.out.println("Let's play Rock, Paper, Scissors!");
		playGame();
	}

	public static void playGame() {
		System.out.println("Choose your weapon:");
		String userInput = getUserWeapon();
		System.out.println("You chose " + userInput + ".");
		String compInput = getComputerWeapon();
		System.out.println("The computer chose " + compInput + ".");
		String c = getWinner(userInput, compInput);
		System.out.println(c);
	}
	
	//reads user input until a valid weapon (rock, paper, scissors) is entered
	public static String getUserWeapon() {
		Scanner reader = new Scanner(System.in);
		String input;
		while(true) {
			try {
				input = reader.next().toLowerCase();
				checkWeapon(input);
				break;
			}catch(Exception e){
				System.out.println("That is not a valid weapon, please try again.");
			}
		}
		return input;
	}
	
	//Throws a exception if a valid weapon is not entered
	public static boolean checkWeapon(String input) {
		if (!(input.equals("rock") || input.equals("paper") || input.equals("scissors"))){
			throw new IllegalArgumentException();
		}
		return true;
	}
	
	//Generates a random number and selects a random weapon for computer based off of number
	public static String getComputerWeapon() {
		String weapon = "";
		Random r = new Random();
		int randomNum = r.nextInt(3) + 1;
		switch (randomNum) {
		case 1:
			weapon = "rock";
			break;
		case 2:
			weapon = "paper";
			break;
		case 3:
			weapon = "scissors";
			break;
		}
		return weapon;
	}
	
	//Checks for Win//Draw cases
	public static String getWinner(String weapon1, String weapon2) {
		if ((weapon1.equals("rock") && weapon2.equals("scissors"))
				|| (weapon1.equals("paper") && weapon2.equals("rock"))
				|| (weapon1.equals("scissors") && weapon2.equals("paper"))) {
			return "You win!";
		}
		if (((weapon2.equals("rock") && weapon1.equals("scissors"))
				|| (weapon2.equals("paper") && weapon1.equals("rock"))
				|| (weapon2.equals("scissors") && weapon1.equals("paper")))) {
			return "The computer wins!";
		} else {
			return "It's a tie!";
		}
	}
	
}
