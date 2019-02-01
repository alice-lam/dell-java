
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
		return dailyRate;
	}
	//multiplies the daily rate by the number of days rented
	public Double getPrice(double days) {
		return getDailyRate()*days;
	}
}
