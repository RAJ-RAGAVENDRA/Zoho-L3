package invoiceApp;

import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {
		Boolean flag = true;
		Scanner sc = new Scanner(System.in);
		Methods m = new Methods();
		Userdb db = new Userdb();

		System.out.println("\t\t\t***Welcome To Invoice Application***");

		do {
			System.out.println(
					"1.Add Customer\n2.Add Invoice\n3.Add Item to Invoice\n4.List all customer\n5.List all Invoices\n6.List all Invoices of Customer\n7.Display an Invoice\n8.Exit");
			int opt = sc.nextInt();

			switch (opt) {
			case 1: {
				System.out.println("---------------------------");
				System.out.println("CustomerID-" + m.addCustomer());
				System.out.println("---------------------------");
				break;
			}

			case 2: {
				int cid = 0;
				System.out.println("1.Existing Customer\n2.New customer");
				int op = sc.nextInt();
				if (op == 1) {
					System.out.println("Enter a customerID");
					cid = sc.nextInt();
					System.out.println("Invoice N.o" + m.addInvoice(cid));
				}
				if (op == 2) {
					cid = m.addCustomer();
					System.out.println("Invoice N.o" + m.addInvoice(cid));
				}
				break;
			}

			case 3: {
				System.out.println("Enter a Invoice N.o");
				int inNum = sc.nextInt();
				m.addItem(inNum);
				break;
			}

			case 4: {

				for (Customer c : db.customerList) {
					System.out.println("Customer ID" + "\tName" + "\tCity" + "\tPhone");
					System.out.println("-------------------------------------------");
					System.out.println(c);
					System.out.println("--------------------------------------------");
				}
				break;
			}

			case 5: {
				for (Invoice i : db.invoiceList) {
					m.displayInvoice(i.invoiceNo);
				}
				break;
			}

			case 6: {
				System.out.println("Enter a CustomerId");
				int cid = sc.nextInt();
				m.printInvoicesOfCustomer(cid);
				break;
			}

			case 7: {
				System.out.println("Enter a Invoice Id:");
				int invoiceId = sc.nextInt();
				m.displayInvoice(invoiceId);
				break;
			}

			case 8: {
				System.out.println("\t\t\t****Thank you****");
				flag = false;
				break;
			}

			default:
				System.out.println("Enter a option--> 1 To 8");
				break;
			}

		} while (flag);

	}

}
