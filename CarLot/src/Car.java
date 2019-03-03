
public class Car extends Vehicle{
	
	private String type;
	private int doorNum;

	public Car(String licenseNum, String make, String model, double price, String type, int doorNum) {
		super(licenseNum, make, model, price);
		this.type = type;
		this.doorNum = doorNum;
	}
	
	//getter for car type
	public String getType() {
		return type;
	}
	//getter for doorNum
	public int getDoorNum() {
		return doorNum;
	}
	//print statement for a car and its properties
	@Override
	public String toString() {
		return ("Car: " + this.getLicenseNum() +" "+ this.getDoorNum() +"-Door "+ this.getType() + " "+ this.getMake() +" "+ this.getModel()+", priced at $" + this.getPrice());
	}

}
