package Taxi;

import java.util.ArrayList;
import java.util.List;

public class DummyBooking {
//-------------------------------------------------------------------------	
	public static List<DummyTaxi> createTaxi(int n)
	{
		List<DummyTaxi> taxis=new ArrayList<DummyTaxi>();
		for (int i = 0; i < n; i++) {
			DummyTaxi d=new DummyTaxi();
			taxis.add(d);
		}
		return taxis;
	}
//------------------------------------------------------------------------------
	public static List<DummyTaxi> getFreeTaxi(List<DummyTaxi>taxis,int pickupTime,char pickupLoc)
	{    List<DummyTaxi>freetaxi=new ArrayList<DummyTaxi>();
		
		for (DummyTaxi t : taxis) {
			
			if (t.availableTime<=pickupTime && (Math.abs((t.availableLocation-'0')-(pickupLoc-'0'))<= pickupTime-t.availableTime)) {
				freetaxi.add(t);
				
			}
		}
		return freetaxi;
		
	}
//------------------------------------------------------------------------------------
	public static void bookTaxi(List<DummyTaxi> freetaxi,int cid,int pickupTime,char pickupLoc,char dropLoc)
	{
		int min=999;
		int earnings=0;
		char availableLoc='R';
        DummyTaxi bookedTaxi=null;
		int availbleTime=0;
		int disBetCustomerAndTaxi=0;
		int disBetPicAndDrop=0;
		String tripDetail="";
		System.out.println("hi");
		
		for (DummyTaxi t : freetaxi) {
			if (disBetCustomerAndTaxi<min) {
				disBetCustomerAndTaxi=Math.abs((t.availableLocation-'0')-(pickupLoc-'0'))*15;
				disBetPicAndDrop=Math.abs((dropLoc-'0')-(pickupLoc-'0'))*15;
				bookedTaxi=t;
				earnings=(disBetPicAndDrop-5)*10+100;
				availableLoc=dropLoc;
				availbleTime=pickupTime+(disBetPicAndDrop/15);
				tripDetail="    "+cid+"     "+cid+"    "+pickupLoc+"     "+dropLoc+"   "+pickupTime+"   "+availbleTime+"   "+earnings; 
				min=disBetCustomerAndTaxi;
			}
		}
		bookedTaxi.setDetails(true, availableLoc, availableLoc, bookedTaxi.earnings+earnings, tripDetail);
		System.out.println(bookedTaxi.id+" is Alloted");
		
		
	}
}