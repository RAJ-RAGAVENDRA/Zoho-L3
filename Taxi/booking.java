package Taxi;

import java.util.ArrayList;
import java.util.List;

public class booking {
//---------------------create Taxis Method----------------------------------------------------------------
	public static List<Taxi> createTaxi(int n) {
		List<Taxi> taxis = new ArrayList<Taxi>();
		for (int i = 0; i < n; i++) {
			Taxi t = new Taxi();
			taxis.add(t);

		}
		return taxis;
	}
//--------------------------Get the free taxis Method-----------------------------------------------------
	public static List<Taxi> getFreeTaxi(List<Taxi> taxis, int pickupTime, char pickupPoint) {
		List<Taxi> freeTaxi = new ArrayList<Taxi>();
		for (Taxi t : taxis) {
			
			if (t.freeTime <= pickupTime && (Math.abs((t.currentLocation - '0') - (pickupPoint - '0')) <= pickupTime - t.freeTime)) {
				freeTaxi.add(t);
			
			}

		}
		return freeTaxi;
	}
//---------------------------Book the taxi----------------------------------------------------------------
	public void bookTaxi(int customerId, char pickupPoint, char dropPoint, int pickupTime, List<Taxi> freeTaxi) {
		int min = 999;
		int distanceBetweenPickupAndDrop = 0;
		int earnings = 0;
		int availableTime = 0;
		char nextSpot = 'Z';
		Taxi bookedTaxi = null;
		String tripDetails = "";

		for (Taxi t : freeTaxi) {
			int distanceBetweenCustomerAndTaxi = Math.abs((t.currentLocation - '0') - (pickupPoint - '0')) * 15;
			if (distanceBetweenCustomerAndTaxi < min) {
				bookedTaxi = t;

				distanceBetweenPickupAndDrop = Math.abs((dropPoint - '0') - (pickupPoint - '0')) * 15;
				earnings = (distanceBetweenPickupAndDrop - 5) * 10 + 100;

				int dropTime = pickupTime + distanceBetweenPickupAndDrop / 15;
				availableTime = dropTime;

				nextSpot = dropPoint;

				tripDetails = "         " + customerId + "             " + customerId + "            " + pickupPoint
						+ "       " + dropPoint + "           " + pickupTime + "              " + dropTime
						+ "              " + earnings;

				min = distanceBetweenCustomerAndTaxi;
			}
		}

		bookedTaxi.setDetails(true, nextSpot, availableTime, bookedTaxi.earnings + earnings, tripDetails);

		System.out.println("Taxi " + bookedTaxi.id + " Booked...");
	}

}
