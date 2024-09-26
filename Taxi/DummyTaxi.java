package Taxi;

import java.util.ArrayList;
import java.util.List;

public class DummyTaxi {
	boolean bookStatus;
	int id;
	static int taxiCount = 1;
	int availableTime;
	char availableLocation;
	int earnings;
	List<String> tripList;

//-------------------------Constructor-------------------------------
	public DummyTaxi() {
		bookStatus=false;
		id = taxiCount++;
		tripList=new ArrayList<String>();
		availableLocation='A';
		earnings=0;
		availableTime=7;
		
	}

//---------------------------Set Details Method--------------------
	public void setDetails(boolean bookStatus, int availableTime, char availableLoc, int earnings,
			String tripDetail) {
		this.availableLocation=availableLoc;
		this.availableTime=availableTime;
		this.bookStatus=bookStatus;
		this.earnings=earnings;
		this.tripList.add(tripDetail);
	}
//---------------------------------------------------------------------
	public void displayDetails()
	{
		System.out.println("------------------------------------------------------");
		System.out.println("TaxiID-->"+this.id+"   "+"Total Earnings"+this.earnings);
		System.out.println("-------------------------------------------------------");
		System.out.println("TaxiId     bookId     customerId     From     To    pickupTime   DropTime    Earnings");
		for (String trips : tripList) {
			System.out.println(" "+id+"  "+trips);
		}
		System.out.println("-------------------------------------------------------");
		
		
		
		
		
	}

}
