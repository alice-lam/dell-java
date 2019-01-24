import java.time.LocalDate;
import java.time.Period;

public class DriversLicense {
	String firstName;
	String lastName;
	private String dob;
	private String height;
	private String gender;
	
	//constructor for a Drivers License
	DriversLicense(String firstName, String lastName, String dob, String height, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.height = height;
		this.gender = gender;
	};
	
	//this returns the obj full name
	String getName() {
		return this.firstName + " " + this.lastName;
	}
	//this returns the obj date of birth
	String dob() {
		return this.dob;
	}
	//this returns the age, finding the time period between current date and dob
	int getAge() {
		LocalDate birthDate = LocalDate.parse(this.dob);
		LocalDate currentDate = LocalDate.now();
	    return Period.between(birthDate, currentDate).getYears();
	}
	//this returns the obj height
	String getHeight() {
		return this.height;
	}
	//this returns the obj full gender
	String getGender() {
		return this.gender;
	}

}
