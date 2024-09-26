package invoiceApp;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	static int icount=0;
    int customerID;
	String name;
	String city;
	long phone;
	List<Invoice> invoice=new ArrayList<Invoice>();
	
	Methods m=new Methods();
	
	public void printInvoices()
	{
		for (Invoice i : invoice) {
			m.displayInvoice(i.invoiceNo);
		}
	}
	
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = icount+customerID;
		icount++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public List<Invoice> getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice.add(invoice);
	}
	@Override
	public String toString() {
		return "   "+customerID +"\t"+  name  +  "\t"  +  city  +  "\t"  +  phone  +  "\n";
	}
	
}
