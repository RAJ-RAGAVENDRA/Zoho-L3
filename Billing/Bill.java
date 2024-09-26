public class Bill
{
    private static int billsCount = 0;
    String bill_no;
    Customer customer;
    Product[] productsBought;
    double total;
    int billID;

    Bill(Customer customer, Product[] productsBought, double total)
    {
        this.customer = customer;
        this.productsBought = productsBought;
        this.total = total;
        billID = ++billsCount;
        bill_no = "Bill-"+billID;
    }
    public int getBillID()
    {
        return billID;
    }

    public void displayBill()
    {
        System.out.println("Bill Number : " + bill_no);
        UtilMethods.printDottedLineLong();
        customer.displayCustomerDetails();
        UtilMethods.printDottedLineLong();

        System.out.println("ProductName\t\tQuantity\t\tPrice\t\tTotal");
        for (Product product: productsBought)
        {
            product.displayBillProduct();
        }
        UtilMethods.printDottedLineLong();

        System.out.println("Total :: " + total);
    }

}
