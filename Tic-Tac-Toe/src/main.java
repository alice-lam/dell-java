import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main {
	static boolean noWinner = true;
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
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col] = " "; // all cells empty
			}
		}
	}

	public static void playGame(String playerLetter) {
		displayBoard();
		System.out.println("Player " + playerLetter
				+ ", please select position. The position must be the column letter followed by the row number, ie. A1:");
		Scanner reader = new Scanner(System.in);
		String input = reader.next().toLowerCase();
		updateLog(playerLetter, input);
		checkWin(playerLetter, board);
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
		}
	}

	public static void updateLog(String playerLetter, String position) {
		int col = 0, row;
		String colString = position.substring(0, 1);
		String rowString = position.substring(1, 2);
		if (colString.equals("a")) {col = 0;}
		if (colString.equals("b")) {col = 1;}
		if (colString.equals("c")) {col = 2;}
		row = Integer.parseInt(rowString)-1;
		board[col][row]= playerLetter;
	}

	public static void displayBoard() {
		System.out.println("    A   B   C  ");
		System.out.println("  +---+---+---+");
		System.out.println("1 | " + board[0][0] + " | " + board[1][0] + " | " + board[2][0] + " |");
		System.out.println("  +---+---+---+");
		System.out.println("2 | " + board[0][1] + " | " + board[1][1] + " | " + board[2][1] + " |");
		System.out.println("  +---+---+---+");
		System.out.println("3 | " + board[0][2] + " | " + board[1][2] + " | " + board[2][2] + " |");
		System.out.println("  +---+---+---+");
	}
}
