
public class CarLotProgram {

	public static void main(String[] args) {
		//creating test car lots
		CarLot test1 = new CarLot("Lot A");
		CarLot test2 = new CarLot("Lot B");
		//creating test vehicles
		Truck mater = new Truck("XYZ123", "Toyota", "Tundra", 42900, "67.2\"");
		Car herbie = new Car("ABCXYZ", "Volkswagen", "Beetle", 20500,"Coupe", 2);
		Car bumblebee = new Car("123456", "Chevrolet", "Camaro", 25999,"Coupe", 2); 
		//adding test vehicles to test car lots
		test1.addVehicle(mater);
		test2.addVehicle(herbie);
		test2.addVehicle(bumblebee);
		
		System.out.println(mater);
		test2.printInventory();
	}

}
