
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
		Double dailyRate = hourlyRate*24;
		return (double)Math.round(dailyRate*100)/100;
	}
	//multiplies the daily rate by the number of days rented
	public Double getPrice(double days) {
		Double finalPrice = getDailyRate()*days;
		return (double)Math.round(finalPrice*100)/100;
	}
}
