
public class Room implements Rentable{
	double dailyRate;
	
	public Room(double dailyRate) {
		this.dailyRate = dailyRate;
	}
	//returns room as the description
	public String getDescription() {
		return "Room";
	}
	//returns daily rate
	public Double getDailyRate() {
		return (double)Math.round(dailyRate*100)/100;
	}
	//multiplies the daily rate by the number of days rented
	public Double getPrice(double days) {
		Double finalPrice = getDailyRate()*days;
		return (double)Math.round(finalPrice*100)/100;
	}
}
