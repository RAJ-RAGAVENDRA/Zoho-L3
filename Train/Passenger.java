package Train;

public class Passenger {
	static int id = 1;
	int passengerId;
	String name;
	int age;
	String preference;
	String alloted;
	int seatNumber;

	public Passenger(String name, int age, String preference) {
		this.name = name;
		this.age = age;
		this.preference = preference;
		passengerId = id++;
		alloted = "";
		seatNumber = -1;
	}

}
