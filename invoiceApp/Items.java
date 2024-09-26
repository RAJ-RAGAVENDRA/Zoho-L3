package invoiceApp;

public class Items {
	int itemId;
	String itemName;
	double itemPrice;
	
	public Items(int id,String itemName,double itemPrice){
		itemId=id;
		this.itemName=itemName;
		this.itemPrice=itemPrice;
	}

	@Override
	public String toString() {
		return  itemName +"        "+ itemPrice;
	}
	
	
	
}
