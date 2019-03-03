import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class RentableProgram {
	public static void main(String[] args) {
		//Generate array of objects with random prices
		Double rand;
		Rentable[] objects = new Rentable[10];
		for (int i=0;i<objects.length;i++) {
			rand = generateRandomNum();
			if(i%3==0) {
				objects[i]= new Tool(rand);
			}
			else if(i%3==1) {
				objects[i]= new Room(rand);
			}
			else if(i%3==2) {
				objects[i]= new Condo(rand);
			}
		}
		printObjects(objects);
		System.out.println("=============");
		generateFinalPrice(objects,getRentalDays());
	}
	//user input: get number of days to rent
	public static double getRentalDays() {
		System.out.println("How many days would you like to rent for?");
		Scanner reader = new Scanner(System.in);
		Double input = reader.nextDouble();
		reader.close();
		return input;
	}

	//generates a random double
	static Double generateRandomNum() {
		Random rand = new Random();
		Double num = (double)rand.nextInt(10) + 20;
		return num;
	}
	//prints out all objects and their daily rates
	static void printObjects(Rentable[] obj) {
		for (Rentable i : obj) {
			System.out.println(i.getDescription() + " w/ daily price of $" + i.getDailyRate());
		}
	}
	//prints out all objects and their final prices
	static void generateFinalPrice(Rentable[] obj, double days) {
		System.out.println("Price after renting for " + days + " days:");
		for(Rentable i : obj) {
			System.out.println(i.getDescription() + ": $" + i.getPrice(days));
		}
	}
}
