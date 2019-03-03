import java.util.ArrayList;
import java.util.List;

public class CarLot {
	private String name;
	private List<Vehicle> inventory = new ArrayList<Vehicle>();
	
	public CarLot(String name) {
		this.name = name;
	}
	//getter for car lot name
	public String getName() {
		return name;
	}
	//adds a vehicle to the inventory list
	public void addVehicle(Vehicle v) {
		this.inventory.add(v);
	}
	
	//iterate through the inventory list and print out vehicle information for each
	public void printInventory() {
		System.out.println("Lot " + this.name + " inventory:");
		for(Vehicle v : inventory) {
			System.out.println(v);
		}
	}
}
