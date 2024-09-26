package Train;

import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {

		Boolean flag = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t***Welcome to Railway Reservation App***");
		do {
			System.out.println();
			System.out.println(
					"Select Any one\n1.Book Ticket\n2.Cancel the Ticket\n3.Available Tickets\n4.Booked Tickets\n5.Exit");
			int opt = sc.nextInt();

			switch (opt) {
			case 1: { // --------------Book Ticket----------------------------------
				System.out.print("Enter Name:");
				String name = sc.next();
				System.out.print("Enter Age:");
				int age = sc.nextInt();
				System.out.print("Enter Berth Preference like:L,M,U");
				String preference = sc.next();
				Passenger p = new Passenger(name, age, preference);
				Booker.bookTicket(p); // --------------->Method call

				break;
			}
			case 2: {// ----------------Cancel Ticket------------------------------
				System.out.print("Enter Passenger to Cancel Ticket:");
				int pid=sc.nextInt();
				if (BookingApp.passengerList.containsKey(pid)) {
					BookingApp.cancelTicket(pid);
				}
				else
				{
					System.out.println("Passenger ID Not Available:");
				}

				break;
			}
			case 3: {// ----------------Available Ticket---------------------------
						System.out.println("----------------------------------------------------------------------");
			        	BookingApp.Availability();
			        	System.out.println("----------------------------------------------------------------------");
				break;
			}
			case 4: {// ---------------Booked Tickets------------------------------
				System.out.println("----------------------------------------------------------------------");
							BookingApp.BookedTickets();
							System.out.println("----------------------------------------------------------------------");
				break;
			}
			case 5: {// ---------------Exit----------------------------------------
				System.out.println("*****Thank You*****");
				flag = false;
				break;
			}

			default:
				System.out.println("Invalid Option--->please select vaild option");
				break;
			}

		} while (flag);

	}

	
}
