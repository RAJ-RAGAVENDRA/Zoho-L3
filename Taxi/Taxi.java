package Taxi;

import java.util.ArrayList;

import java.util.List;

public class Taxi {
	static int taxiCount = 1;
	int id;
	boolean booked;
	char currentLocation;
	int freeTime;
	int earnings;
	List<String> trips;

//-----------------------Constructor for initialize every taxi Object----------------
	public Taxi() {
		id = taxiCount++;
		booked = false;
		currentLocation = 'A';
		freeTime = 7;
		earnings = 0;
		trips = new ArrayList<String>();

	}
//--------------Set Details Method-----------------------------------------------
	public void setDetails(boolean booked, char currentLocation, int freeTime, int earnings, String tripDetails) {
		this.booked = booked;
		this.currentLocation = currentLocation;
		this.freeTime = freeTime;
		this.earnings = earnings;
		this.trips.add(tripDetails);

	}
//--------------------------------Print details method----------------------------
	public void printDetails() {
		System.out.println("Taxi-- " + this.id + " Total Earnings-- " + this.earnings);
		System.out.println(
				"| TaxiID  | BookingId  |  CustomerID  |  from  |  To  |   PickupTime   |   DropTime  |  AmountEarnings |");
		for (String trip : trips) {
			System.out.println("     " + id + " " + trip);
			System.out.println(
					"-------------------------------------------------------------------------------------------------------");
		}
	}

}
