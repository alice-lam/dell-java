
public class ParkingGarage {
	int capacity;
	private Car[] parkingSpots;
	
	//Garage constructor, creates array of cars with capacity n spots
	ParkingGarage(int capacity){
		this.capacity = capacity;
		this.parkingSpots = new Car[capacity];
	}
	
	//Throws exception if not a valid spot in array
	void checkValidSpot(int spot) {
		if(spot<0 || spot>this.capacity) {
			throw new IllegalArgumentException();
		}
		return;
	}
	
	void park(Car car, int spot){
		try {
			checkValidSpot(spot);
			if (this.parkingSpots[spot]==null) {
				parkingSpots[spot] = car;
				return;
			}
			else {
				System.out.println("You cannot park here, there is a car already in this stall.");
				return;
			}
				
		}catch(Exception e) {
			System.out.println("This is an invalid spot.");
		}
	}
	
	
	void vacate(int spot){
		try {
			checkValidSpot(spot);
			if(this.parkingSpots[spot] == null){
				System.out.println("This spot is already empty.");
				return;
			}
			else {
				this.parkingSpots[spot]=null;
				return;
			}
				
		}catch(Exception e) {
			System.out.println("This is an invalid spot.");
		}
	}
	
	void printInventory(){
		System.out.println("\nGarage Inventory:");
		for (int i=0; i<parkingSpots.length; i++) {
			if(parkingSpots[i]==null) {
				System.out.println("Stall " + i + " is empty.");	
			}
			else{
				System.out.println("Stall " + i + ": " + parkingSpots[i].color + " " + parkingSpots[i].make + " " + parkingSpots[i].model + ", plate #" + parkingSpots[i].plate);
			}
		}
	}
	
	
}
