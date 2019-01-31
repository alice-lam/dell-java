
public abstract class Vehicle {
	private String licenseNum;
	private String make;
	private String model;
	private double price;
	
	public Vehicle(String licenseNum, String make, String model, double price) {
		this.licenseNum = licenseNum;
		this.make = make;
		this.model = model;
		this.price = price;
	}
	//getter for license plate number
	public String getLicenseNum() {
		return licenseNum;
	}
	//getter for make
	public String getMake() {
		return make;
	}
	//getter for model
	public String getModel() {
		return model;
	}
	//getter for price
	public double getPrice() {
		return price;
	}
	
}
