
public class Condo implements Rentable{
	double weeklyRate;
	
	public Condo (double weeklyRate) {
		this.weeklyRate = weeklyRate;
	}
	//returns condo as description
	public String getDescription() {
		return "Condo";
	}
	//to get daily rate, divide weekly rate by 7
	public Double getDailyRate() {
		return weeklyRate/7;
	}
	//multiplies the daily rate by the number of days rented
	public Double getPrice(double days) {
		// TODO Auto-generated method stub
		return getDailyRate()*days;
	}
}
