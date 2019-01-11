import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		System.out.println("Hi, please enter your numbers, with a comma separating each number:");
		Scanner reader = new Scanner(System.in);
		String input = reader.next();
		String[] stringNumbers = input.split(",");
		double[] numbers = new double[stringNumbers.length];
		for (int i=0; i<numbers.length; i++) {
			numbers[i] = Double.parseDouble(stringNumbers[i]);
			
		}
		Arrays.sort(numbers);
		System.out.println("There are " + getSize(numbers) + " elements.");
		System.out.println("The minimum of these values is " + getMin(numbers));
		System.out.println("The maximum of these values is " + getMax(numbers));
		System.out.println("The average of these values is " + getAverage(numbers));
		System.out.println("The sum of these values is " + getSum(numbers));
	}
	
	public static double getMin(double[] sortedNumbers) {
		return sortedNumbers[0];
	}
	
	public static double getMax(double[] sortedNumbers) 
	{
		return sortedNumbers[sortedNumbers.length-1];
	}
	
	public static int getSize(double[] sortedNumbers) {
		return sortedNumbers.length;
	}
	
	public static double getAverage(double[] sortedNumbers) {
		double total = getSum(sortedNumbers);
		return total/sortedNumbers.length;
	}
	
	public static double getSum(double[] sortedNumbers) {
		double total = 0;
		for (int i = 0; i <sortedNumbers.length; i++) {
			System.out.println(sortedNumbers[i]);
			total += sortedNumbers[i];
		}
		return total;
	}
}
