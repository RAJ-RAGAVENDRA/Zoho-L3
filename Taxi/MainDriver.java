package Taxi;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args)  {

		boolean flag = true;
		int id = 1;
		booking bo = new booking();
		List<Taxi> taxis = booking.createTaxi(4);

		do {
			System.out.println("Select Any One\n1.Book taxi\n2.Display\n3.Exit");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();

			switch (n) {
			case 1: {

				System.out.print("Enter a PickupLocation---");
				char pickupLocation = sc.next().charAt(0);
				System.out.println("Enter a DropLocation---");
				char dropLocation = sc.next().charAt(0);
				System.out.println("Enter a PickupTime---");
				int pickupTime = sc.nextInt();

				if (pickupLocation < 'A' || dropLocation > 'F' || pickupLocation > 'F' || dropLocation < 'A') {
					System.out.println("----Invalid Location---");
					System.out.println("Valid Only--->A,B,C,D,E,F.");
					sc.close();
					return;

				}

				List<Taxi> freeTaxi = booking.getFreeTaxi(taxis, pickupTime, pickupLocation);
				if (freeTaxi.size() == 0) {
					System.out.println("Sorry...Taxi Not Available...");
					sc.close();
					return;
				}

				Collections.sort(freeTaxi, (a, b) -> a.earnings - b.earnings);

				bo.bookTaxi(id, pickupLocation, dropLocation, pickupTime, freeTaxi);
				id++;
				break;

			}

			case 2: {
				for (Taxi t : taxis)
					t.printDetails();
				break;
			}

			case 3: {
				flag = false;
				System.out.println("****Thank You****");
				sc.close();
			}

			default:
				break;
			}

		} while (flag);

	}

}
