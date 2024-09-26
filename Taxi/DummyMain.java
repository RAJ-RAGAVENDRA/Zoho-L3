package Taxi;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DummyMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DummyBooking db = new DummyBooking();
		boolean flag = true;
		int customerId = 1;

		List<DummyTaxi> taxis = db.createTaxi(4);

		System.out.println("\t\t\tWelcome To Zoho Taxis");
		do {
			System.out.println("select option:\n1.Book Taxi\n2.Display\n3.Exit");
			int opt = sc.nextInt();
			switch (opt) {
			case 1: {
				System.out.println("Enter a PickupLocation");
				char pickuploc = sc.next().charAt(0);
				System.out.println("Enter a DropLocation");
				char dropLoc = sc.next().charAt(0);
				System.out.println("Enter pickupTime");
				int pickupTime = sc.nextInt();

				if (pickuploc < 'A' || pickuploc > 'D' || dropLoc < 'A' || dropLoc > 'D') {
					System.out.println("Invalid Option\nEnter Again");
					break;
				}
				
				List<DummyTaxi> freeTaxi = db.getFreeTaxi(taxis, pickupTime, pickuploc);

				if (freeTaxi.size() == 0) {
					System.out.println("No Taxi Available....");
					break;
				}
				
				Collections.sort(freeTaxi, (a, b) -> a.earnings - b.earnings);

				db.bookTaxi(freeTaxi, customerId, pickupTime, pickuploc, dropLoc);
				customerId++;

				break;
			}

			case 2: {
				for (DummyTaxi dummyTaxi : taxis) {
					dummyTaxi.displayDetails();
					;
				}

				break;
			}
			case 3: {
				System.out.println("Thank you.....");
				flag=false;
				break;
			}
			}

		} while (flag);

	}

}