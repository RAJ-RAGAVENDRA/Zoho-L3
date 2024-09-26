package invoiceApp;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	static int invoiceNocount=0;
	int invoiceNo;
	List<Items> itemList=new ArrayList();
	int totalItems=0;
	double tottalPrice=0.0;
	Customer c;
	
	public void printItems()
	{
		for (Items i : itemList) {
			System.out.println(i);
		}
	}


	public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNocount+invoiceNo;
		invoiceNocount++;
	}
	public List<Items> getItemList() {
		return itemList;
	}
	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getTottalPrice() {
		return tottalPrice;
	}
	public void setTottalPrice(double tottalPrice) {
		this.tottalPrice = tottalPrice;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	
	@Override
	public String toString() {
		return "invoiceNo=" + invoiceNo + ", totalItems=" + totalItems + ", tottalPrice=" + tottalPrice+ "\n";
	}
	
	
	
	
	

}
