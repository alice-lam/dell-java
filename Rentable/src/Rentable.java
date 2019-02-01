
public interface Rentable {
	//returns the description of the item
	String getDescription();
	//returns the daily rate for renting the item
	Double getDailyRate();
	//returns the amount due for renting the item for the a given number of days
	Double getPrice(double days);
}
