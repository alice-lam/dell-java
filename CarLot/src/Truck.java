
public class Truck extends Vehicle{
	private String bedSize;

	public Truck(String licenseNum, String make, String model, double price, String bedSize) {
		super(licenseNum, make, model, price);
		this.bedSize = bedSize;
	}
	//getter for bedsize
	public String getBedSize() {
		return bedSize;
	}
	//print statement for a truck and its properties
	@Override
	public String toString() {
		return ("Truck: " + this.getLicenseNum() +" "+ this.getMake() +" "+ this.getModel() +", with a bedsize "+ this.getBedSize()+", priced at $" + this.getPrice());
	}
}
