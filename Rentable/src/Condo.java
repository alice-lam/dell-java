
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
		Double dailyRate = weeklyRate/7;
		return (double)Math.round(dailyRate*100)/100;
	}
	//multiplies the daily rate by the number of days rented
	public Double getPrice(double days) {
		Double finalPrice = getDailyRate()*days;
		return (double)Math.round(finalPrice*100)/100;
	}
}
