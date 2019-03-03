public class Car {
	private String color;
	private String make;
	private String model;
	private String plate;
	
	//Car constructor
	Car(String color, String make, String model, String plate){
		this.color = color;
		this.make = make;
		this.model = model;
		this.plate = plate;
	}
	
	String getColor() {
		return this.color;
	}
	String getMake() {
		return this.make;
	}
	String getModel() {
		return this.model;
	}
	String getPlate() {
		return this.plate;
	}
}
