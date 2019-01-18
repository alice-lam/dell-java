import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class main {
	static boolean run = true;
	static Scanner reader = new Scanner(System.in);
	static HashMap<String, String> studentGradebook = new HashMap<String, String>();
	static HashMap<String, Double> studentReportCard = new HashMap<String, Double>();

	public static void main(String[] args) {

		System.out.println("Welcome to the Gradebook system.");

		while (run) {
			runGradebook();
		}
		System.exit(0);
	}

	public static void runGradebook() {
		String input;
		boolean isValid = true;
		//keep running until a valid input is entered
		do {
			System.out.println("Gradebook Menu ");
			System.out.println("1. Input new grades for a student");
			System.out.println("2. View grade average for a student(s)");
			System.out.println("3. Exit Program");
			System.out.print("Please select one of the above options: ");
			input = reader.next();
			isValid = parseInput(input);
		} while (!isValid);
	}
	
	//Takes a string input and determines which function to proceed to
	public static boolean parseInput(String inputWord) {
		if (inputWord.equals("1")) {
			addGrades();
			return true;
		}
		if (inputWord.equals("2")) {
			returnAverage();
			return true;
		}
		if (inputWord.equals("3")) {
			System.out.println("Signing off, goodbye.");
			run = false;
			return true;
		} else {
			System.out.println("Not a valid option.");
			return false;
		}
	}
	
	//Takes student name and stores inputted grades and calculated average into hashmaps
	public static void addGrades() {
		System.out.print("Please enter the name of the student: ");
		String name = reader.next();
		System.out.print("Please enter the grades for " + name + ", with a comma separating each number: ");
		String grades = reader.next();
		double average = calculateAverage(grades);
		studentGradebook.put(name, grades);
		studentReportCard.put(name, average);
		System.out.println("Grades inputted, returning to main menu.");
		System.out.println();
	}
	
	//Takes string input, converts entries into integers, calculates, and returns average
	public static double calculateAverage(String numberInput) {
		double temp = 0;
		String[] stringNumbers = numberInput.split(",");
		for (int i = 0; i < stringNumbers.length; i++) {
			temp += Integer.parseInt(stringNumbers[i]);
		}
		temp = temp / stringNumbers.length;
		return temp;
	}
	
	//Asks user for keyname, validates, and returns average from the input keyname.
	public static void returnAverage() {
		boolean nameExists = true;
		String name;
		do {
			System.out.print("Please enter the name of the student you would like to retrieve grades for, or type 'ALL' for all students: ");
			name = reader.next();
			if (name.equals("ALL")) {
				printStudentsGrades();
				return;
			}
			nameExists = studentReportCard.containsKey(name);
			if (nameExists == false) {
				System.out.println("Cannot find name in Gradebook, please try again.");
				System.out.println();
			}
		} while (!nameExists);
		System.out.println("Average grade for " + name + ": " + studentReportCard.get(name));
		System.out.println();
		return;
	}
	
	//printStudentGrades prints out all students name and Average
	public static void printStudentsGrades() {
		Iterator it = studentReportCard.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + "'s average: " + pair.getValue());
			it.remove();
		}
		System.out.println();
		return;
	}
}
