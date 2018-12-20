import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello. What is your name?");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		System.out.println("Hello " + input + ", hope you are doing well.");
		reader.close();
	}

}