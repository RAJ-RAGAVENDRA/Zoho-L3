package invoiceApp;

import java.util.Arrays;
import java.util.Scanner;

import javax.naming.directory.AttributeInUseException;

public class Methods {
	static Scanner sc = new Scanner(System.in);
	static Userdb db = new Userdb();

	public static int addCustomer() {
		System.out.println("Enter a Name:");
		String name = sc.next();
		System.out.println("Enter a City");
		String city = sc.next();
		System.out.println("Enter a phone");
		long phone = sc.nextLong();
		

		Customer c = new Customer();
		c.setCustomerID(1);
		c.setName(name);
		c.setCity(city);
		c.setPhone(phone);
		db.customerList.add(c);
		return c.customerID;

	}

//--------------------------------------------------------------------------------------------------------------
	public static int addInvoice(int cid) {
		Customer cus = null;
		Invoice in = new Invoice();
		in.setInvoiceNo(1);
		
		for (Customer c : db.customerList) {
			if (cid == c.customerID) {
				cus = c;
				break;
			}
		}
		boolean flag = true;
		while (flag) {
			System.out.println(
					"Select The item\n1.Headphone Rs.500\n2.Speaker Rs.900\n3.Mobile Rs.50000\n4.cover Rs.200");
			int i = sc.nextInt();
			Items item = db.ItemsList[i - 1];
			in.tottalPrice = in.tottalPrice + item.itemPrice;
			in.itemList.add(item);
			System.out.println("Are you want add one more? Yes 1 or No 0");
			int add = sc.nextInt();
			if (add == 0) {
				in.totalItems = in.itemList.size();
				flag = false;
			}
		}
		in.c = cus;
		cus.invoice.add(in);
		db.invoiceList.add(in);
		return in.invoiceNo;
	}
//---------------------------------------------------------------------------------------------------------------------
	public static void addItem(int inNum)
	{	Invoice in=null;
	     
		for (Invoice i : db.invoiceList) {
			if (inNum==i.invoiceNo) {
				in=i;
				break;
			}
		}
		boolean flag = true;
		while (flag) {
			System.out.println(
					"Select The item\n1.Headphone Rs.500\n2.Speaker Rs.900\n3.Mobile Rs.50000\n4.cover Rs.200");
			int i = sc.nextInt();
			Items item = db.ItemsList[i - 1];
			in.tottalPrice = in.tottalPrice + item.itemPrice;
			in.itemList.add(item);
			System.out.println("Are you want add one more? Yes 1 or No 0");
			int add = sc.nextInt();
			if (add == 0) {
				in.totalItems = in.itemList.size();
				flag = false;
			}
		}
  
		
	}
//-------------------------------------------------------------------------------------------------------------------	
	public static void printInvoicesOfCustomer(int cid)
	{
		System.out.println("-------------------------------------");
		for (Customer c : db.customerList) {
			if (c.customerID==cid) {
				c.printInvoices();
			}
		}
		System.out.println("--------------------------------------");
	}
//--------------------------------------------------------------------------
	public static void displayInvoice(int inId)
	{
		for (Invoice i : db.invoiceList) {
			if (i.invoiceNo==inId) {
				System.out.println("Invoice N.o-    "+i.invoiceNo);
				System.out.println("---------------------------------------");
				System.out.println("Name:"+i.c.name+"      "+"Phone"+i.c.phone);
				System.out.println("ItemName          Unit price");
				System.out.println("-----------------------------------------");
				i.printItems();
				System.out.println("----------------------------------");
				System.out.println("Total Items    "+i.totalItems+"     "+"TotalPrice  "+i.tottalPrice);
				System.out.println("---------------------------------------");
			}
		}
		
	}
}
