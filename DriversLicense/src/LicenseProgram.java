
public class LicenseProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DriversLicense test1 = new DriversLicense("John", "Doe", "1990-01-14", "6'5", "Male");
		DriversLicense test2 = new DriversLicense("Jane", "Doe", "1992-08-16", "5'4", "Female");
		DriversLicense test3 = new DriversLicense("Alice", "Lam", "1994-09-17", "5'3", "Female");
		System.out.println(test1.getName() + ": Age " + test1.getAge() +", " + test1.getGender());
		System.out.println(test2.getName() + ": Age " + test2.getAge() +", " + test2.getGender());
		System.out.println(test3.getName() + ": Age " + test3.getAge() +", " + test3.getGender());
	}

}
