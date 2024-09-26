import java.util.Scanner;

public class Customer
{
    public static Scanner getInput = new Scanner(System.in);
    String customerName;
    String phoneNumber;
    String address;

    public Customer(String customerName, String phoneNumber, String address) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public static Customer getCustomerDetails()
    {
        System.out.print("Enter Your Name: ");
        String name = getInput.next();

        System.out.print("Enter Your Phone number: ");
        String phoneNumber = Run.getInput.next();

        System.out.print("Enter Your Address: ");
        String address = Run.getInput.next();

        return new Customer(name, phoneNumber, address);
    }

    public void displayCustomerDetails()
    {
        System.out.println("Name : " + this.customerName);
        System.out.println("Phone Number : " + this.phoneNumber);
        System.out.println("Address : " + this.address);
    }
}
