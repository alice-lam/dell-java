import java.util.Random;

public class GarageManager {
	public static void main(String[] args) {
		//Parking Garage 1 with 20 spots
		ParkingGarage garage1 = new ParkingGarage(15);
		//Parking Garage 2 with 50 spots
		ParkingGarage garage2 = new ParkingGarage(12);
		//Parking Garage 3 with 100 spots
		ParkingGarage garage3 = new ParkingGarage(10);
		
		//test car
		Car othertestcar = new Car("Black", "Volkswagen", "Beetle", generateRandomPlate());
		
		//Test 1: Fill up garage 1 and print log 
		System.out.println("===Test 1===");
		for(int i = 0 ; i<garage1.capacity; i++){
			Car testcar = new Car("Blue", "Volkswagen", "Beetle", generateRandomPlate());
			garage1.park(testcar, i);
		}
		garage1.printInventory();
		
		//Test 2: Add cars in garage2, try to park 2 cars in same spot
		System.out.println("\n===Test 2===");
		for (int i=0; i<garage2.capacity; i+=4) {
			Car testcar2 = new Car("Red", "Volkswagen", "Beetle", generateRandomPlate());
			garage2.park(testcar2, i);
		}
		//this should fail
		garage2.park(othertestcar, 4);
		//this should fail
		garage2.park(othertestcar, 8);
		//this should pass
		garage2.park(othertestcar, 10);
		garage2.printInventory();
		
		//Test 3: Add cars into garage3, vacate cars, should also try to park in invalid spot
		System.out.println("\n===Test 3===");
		for (int i=0; i<garage3.capacity; i+=2) {
			Car testcar3 = new Car("Yellow", "Volkswagen", "Beetle", generateRandomPlate());
			garage3.park(testcar3, i);
		}
		//this should fail
		garage3.park(othertestcar, 31);
		//this should fail
		garage3.park(othertestcar, -1);
		//this should fail
		garage3.vacate(3);
		//this should pass
		garage3.vacate(8);
		garage3.park(othertestcar, 8);
		garage3.printInventory();
		
	}
	//Selects a random letter and random 3 digits for a license plate
	static String generateRandomPlate() {
		Random rand = new Random();
		String num = String.valueOf(rand.nextInt(899) + 100);
		String letter = String.valueOf((char)(rand.nextInt(26)+'A'));
		String plate = letter + num;
		return plate;
	}
}
