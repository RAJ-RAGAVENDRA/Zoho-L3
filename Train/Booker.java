package Train;

public class Booker {
	public static void bookTicket(Passenger p) {
		BookingApp app = new BookingApp();

		if (app.availableWaitingList == 0) {
			System.out.println("No Tickets are Available....");
		}
//------------------check the preference is available or not---------------------------------------------		
		if ((p.preference.equals("L") && app.availableLowerBerth > 0)
				|| (p.preference.equals("M") && app.availableMiddleBerth > 0)
				|| (p.preference.equals("U") && app.availableUpperBerth > 0)) {
			if (p.preference.equals("L")) {
				System.out.println("Preffered Berth is Available:" + p.preference);
				System.out.println("passengerId:" + p.passengerId);
				BookingApp.bookTicket(p, BookingApp.lowerBerthSeat.get(0), "L");
				BookingApp.lowerBerthSeat.remove(0);
				BookingApp.availableLowerBerth--;
			} else if (p.preference.equals("M")) {
				System.out.println("Preffered Berth is Available:" + p.preference);
				System.out.println("passengerId:" + p.passengerId);
				BookingApp.bookTicket(p, BookingApp.middleBerthSeat.get(0), "M");
				BookingApp.middleBerthSeat.remove(0);
				BookingApp.availableMiddleBerth--;

			} else if (p.preference.equals("U")) {
				System.out.println("Preffered Berth is Available:" + p.preference);
				System.out.println("passengerId:" + p.passengerId);
				BookingApp.bookTicket(p, BookingApp.upperBerthSeat.get(0), "U");
				BookingApp.upperBerthSeat.remove(0);
				BookingApp.availableUpperBerth--;
			}
		}
//-------------------If preference is not available then book available ticket--------------------------------
		else if (app.availableLowerBerth > 0) {
			System.out.println("Preffered Berth is Not Available:" + p.preference);
			BookingApp.bookTicket(p, BookingApp.lowerBerthSeat.get(0), "L");
			System.out.println("passengerId:" + p.passengerId);
			BookingApp.lowerBerthSeat.remove(0);
			BookingApp.availableLowerBerth--;

		} else if (app.availableMiddleBerth > 0) {
			System.out.println("Preffered Berth is Not Available:" + p.preference);
			BookingApp.bookTicket(p, BookingApp.middleBerthSeat.get(0), "M");
			System.out.println("passengerId:" + p.passengerId);
			BookingApp.middleBerthSeat.remove(0);
			BookingApp.availableMiddleBerth--;
		} else if (app.availableUpperBerth > 0) {
			System.out.println("Preffered Berth is Not Available:" + p.preference);
			BookingApp.bookTicket(p, BookingApp.upperBerthSeat.get(0), "U");
			System.out.println("passengerId:" + p.passengerId);
			BookingApp.upperBerthSeat.remove(0);
			BookingApp.availableUpperBerth--;
		} else if (app.availableRAC > 0) {
			System.out.println("Preffered Berth is Not Available:" + p.preference);
			BookingApp.bookTicket(p, BookingApp.racSeat.get(0), "RAC");
			System.out.println("passengerId:" + p.passengerId);
			BookingApp.racSeat.remove(0);
			BookingApp.availableRAC--;

		} else if (app.availableWaitingList > 0) {
			System.out.println("Preffered Berth is Not Available:" + p.preference);
			BookingApp.bookTicket(p, BookingApp.waitListToken.get(0), "WL");
			System.out.println("passengerId:" + p.passengerId);
			BookingApp.waitListToken.remove(0);
			BookingApp.availableWaitingList--;
		}

	}
}
