package Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BookingApp {

	static int availableLowerBerth = 3;
	static int availableMiddleBerth = 3;
	static int availableUpperBerth = 3;
	static int availableRAC = 1;
	static int availableWaitingList = 1;

	static List<Integer> lowerBerthSeat = new ArrayList<Integer>(Arrays.asList(1,2,3));
	static List<Integer> middleBerthSeat = new ArrayList<Integer>(Arrays.asList(1,2,3));
	static List<Integer> upperBerthSeat = new ArrayList<Integer>(Arrays.asList(1,2,3));
	static List<Integer> racSeat = new ArrayList<Integer>(Arrays.asList(1));
	static List<Integer> waitListToken = new ArrayList<Integer>(Arrays.asList(1));

	static List<Integer> bookedTicketsList = new ArrayList<Integer>();
	static List<Integer> racList = new ArrayList<Integer>();
	static List<Integer> waitingList = new ArrayList<Integer>();

	static Map<Integer, Passenger> passengerList = new HashMap<Integer, Passenger>();

//--------------------------------Book Ticket Methods-----------------------------------------------------------
	public static void bookTicket(Passenger p, int seatNumber, String alloted) {
		p.alloted = alloted;
		p.seatNumber = seatNumber;
		passengerList.put(p.passengerId, p);

		if (p.alloted.equals("RAC")) {
			racList.add(p.passengerId);
			System.out.println("Added To RAC...");
		} else if (p.alloted.equals("WL")) {
			waitingList.add(p.passengerId);
			System.out.println("Added To WaitingList...");
		} else {
			bookedTicketsList.add(p.passengerId);
			System.out.println("Ticket Booked Successfully...");
		}

	}

//-----------------------------------Cancel ticket Method----------------------------------------------------------------------	
	public static void cancelTicket(int pid) {
		Passenger cancelPassenger=passengerList.get(pid);
		int cancelSeatNum=cancelPassenger.passengerId;
		bookedTicketsList.remove(bookedTicketsList.indexOf(cancelPassenger.passengerId));
	   passengerList.remove(cancelPassenger.passengerId);
		
		if (cancelPassenger.alloted.equals("L")){
			lowerBerthSeat.add(cancelSeatNum);
			availableLowerBerth++;	
		}
		else if (cancelPassenger.alloted.equals("M")){
			middleBerthSeat.add(cancelSeatNum);
			availableMiddleBerth++;
			
		}
		else if (cancelPassenger.alloted.equals("U")){
			upperBerthSeat.add(cancelSeatNum);
			availableUpperBerth++;
			
		}
		System.out.println("Ticket Cancelled Successfully..");
		
		if (racList.size()>0){
			Passenger passengerFromRac=passengerList.get(racList.get(0));
			int racSeatNum=passengerFromRac.seatNumber;
			racSeat.add(racSeatNum);
			racList.remove(racList.indexOf(passengerFromRac.passengerId));
			availableRAC++;
			
			if (waitingList.size()>0){
				Passenger passengerFromWL=passengerList.get(waitingList.get(0));
				int wlTokenNum=passengerFromWL.seatNumber;
				waitingList.remove(waitingList.indexOf(passengerFromWL.passengerId));
				waitListToken.add(wlTokenNum);
				availableWaitingList++;
				
				passengerFromWL.alloted="RAC";
				passengerFromRac.seatNumber=racSeatNum;
				racList.add(passengerFromWL.passengerId);
				availableRAC--;
				
				
			}
	        Booker.bookTicket(passengerFromRac);
			}

	}
//--------------------------------------------------------------------------------------------------------------
	public static void Availability()
	{
		System.out.println("-----------------------------------");
		System.out.println("available Lower Berth:"+availableLowerBerth);
		System.out.println("available Middle Berth:"+availableMiddleBerth);
		System.out.println("available Upper Berth:"+availableUpperBerth);
		System.out.println("available RAC:"+availableRAC);
		System.out.println("available WaitingList:"+availableWaitingList);
	}	
//---------------------------------------------------------------------------------------------------------------------
    public static void BookedTickets()
    {
    	for (Passenger p : passengerList.values()){
    	
    		System.out.println("Passenger ID:"+p.passengerId);
    		System.out.println("Name:"+p.name);
    		System.out.println("Status:"+p.alloted+p.seatNumber);
    		System.out.println("-----------------------------------");
    		
    		
			
		}
    }



}
