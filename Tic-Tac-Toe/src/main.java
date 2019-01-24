import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main {
	static boolean noWinner = true;
	static int counter= 0;
	static String playerLetter = "";
	//create a new board[rows][cols]
	public static String[][] board = new String[3][3];

	public static void main(String[] args) {
		init();
		System.out.println("Welcome to Tic Tac Toe:");
		while (noWinner) {
			if (playerLetter.equals("X")) {
				playerLetter = "O";
			} else {
				playerLetter = "X";
			}
			playGame(playerLetter);
		}
		displayBoard();
		System.out.println(playerLetter + " Wins!");
	}

	public static void init() {
		// create a board with all cells empty
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[col][row] = " "; 
			}
		}
	}

	public static void playGame(String playerLetter) {
		displayBoard();
		String input;
		boolean isValidInput = true;
		do {
			System.out.println("Player " + playerLetter + ", please select position. The position must be the row letter followed by the column number, ie. A1:");
			Scanner reader = new Scanner(System.in);
			input = reader.next().toLowerCase();
			isValidInput = checkInput(input, board);
		}while(!isValidInput);
		
		updateBoard(playerLetter, input);
		checkWin(playerLetter, board);
	}
	
	public static boolean checkInput(String input, String[][] board) {
		String row = input.substring(0,1);
		String col = input.substring(1,2);
		int rowInt = 0, colInt;
		//check for valid row input
		if (!((row.equals("a")||row.equals("b")||row.equals("c")))) {
			System.out.println("Not a valid row input.");
			return false;
		}
		//check for valid col input
		if (!((col.equals("1")||col.equals("2")||col.equals("3")))) {
			System.out.println("Not a valid column input.");
			return false;
		}
		//check to see if space is available
		if (row.equals("a")) {rowInt = 0;}
		if (row.equals("b")) {rowInt = 1;}
		if (row.equals("c")) {rowInt = 2;}
		colInt = Integer.parseInt(col)-1;
		if (!(board[colInt][rowInt].equals(" "))){
			System.out.println("This position has already been filled.");
			return false;
		}
		return true;
	}
	
	public static void checkWin(String player, String[][] board) {
		if (((board[0][0] == player)&&(board[0][1] == player)&&(board[0][2] == player))||
			((board[1][0] == player)&&(board[1][1] == player)&&(board[1][2] == player))||
			((board[2][0] == player)&&(board[2][1] == player)&&(board[2][2] == player))||
			((board[0][0] == player)&&(board[1][0] == player)&&(board[2][0] == player))||
			((board[0][1] == player)&&(board[1][1] == player)&&(board[2][1] == player))||
			((board[0][2] == player)&&(board[1][2] == player)&&(board[2][2] == player))||
			((board[0][0] == player)&&(board[1][1] == player)&&(board[2][2] == player))||
			((board[0][2] == player)&&(board[1][1] == player)&&(board[2][0] == player))){
			noWinner = false;
			return;
		}
		counter += 1;
		if (counter == 9) {
			displayBoard();
			System.out.println("It's a draw!");
			System.exit(0);
		}
	}

	public static void updateBoard(String playerLetter, String position) {
		int row = 0, col;
		String rowString = position.substring(0, 1);
		String colString = position.substring(1, 2);
		if (rowString.equals("a")) {row = 0;}
		if (rowString.equals("b")) {row = 1;}
		if (rowString.equals("c")) {row = 2;}
		col = Integer.parseInt(colString)-1;
		board[col][row]= playerLetter;
	}

	public static void displayBoard() {
		System.out.println("    1   2   3  ");
		System.out.println("  +---+---+---+");
		System.out.println("A | " + board[0][0] + " | " + board[1][0] + " | " + board[2][0] + " |");
		System.out.println("  +---+---+---+");
		System.out.println("B | " + board[0][1] + " | " + board[1][1] + " | " + board[2][1] + " |");
		System.out.println("  +---+---+---+");
		System.out.println("C | " + board[0][2] + " | " + board[1][2] + " | " + board[2][2] + " |");
		System.out.println("  +---+---+---+");
	}
}
