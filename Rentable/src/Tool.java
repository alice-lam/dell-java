
public class Tool implements Rentable{
	
	double hourlyRate;
		
	public Tool(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	//returns tool as the description
	public String getDescription() {
		return "Tool";
	}
	//multiplies the hourlyrate by 24 to get the daily rate
	public Double getDailyRate() {
		return hourlyRate*24;
	}
	//multiplies the daily rate by the number of days rented
	public Double getPrice(double days) {
		return getDailyRate()*days;
	}
}
