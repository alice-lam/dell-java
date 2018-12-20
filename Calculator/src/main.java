import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		System.out.println("Hello, welcome to the calculator. Please enter the first number:");
		Scanner reader = new Scanner(System.in);
		int num1 = getNumberInput();
		System.out.println("Okay, what's the second number:");
		int num2 = getNumberInput();
		System.out.println("Please enter the operator for the function you would like to perform:");
		String operator = reader.nextLine();
		int result = calculate(num1, num2, operator);
		System.out.println(num1 + operator + num2 + "=" + result);
		reader.close();
	}
	
	public static int getNumberInput() {
		String x = "";
		Scanner reader = new Scanner(System.in);
		while(!reader.hasNextInt()) {
			System.out.println("That is not a valid number. Please try again.");
			reader.next();
		}
		return reader.nextInt();
	}
	
	public static int calculate(int a, int b, String operator) {
		int result=0;
		if (operator.equals("+")){
			result = a+b;
		}
		if (operator.equals("-")){
			result = a-b;
		}
		if (operator.equals("*")){
			result = a*b;
		}
		if (operator.equals("/")){
			result = a/b;
		}
		if (operator.equals("%")){
			result = a%b;
		}
		return result;
	}
	
	public static int fib(int n) {
		if (n<2) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	} 
	
}
