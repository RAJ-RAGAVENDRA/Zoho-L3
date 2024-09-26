import java.util.Scanner;

public class Run
{
    public static Scanner getInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        Company myCompany = new Company("Sarah Mart");
        boolean run = true;

        do {
            displayOptionsToEnter();
            int option = getInput.nextInt();
            UtilMethods.printDottedLineLong();
            switch (option)
            {
                case 1:
                    myCompany.displayProductsInCompanyStock();
                    break;
                case 2:
                    myCompany.createBill();
                    break;
                case 3:
                    run = false;
                    break;
            }
            UtilMethods.printDottedLineLong();
        }
        while (run);

    }

    private static void displayOptionsToEnter()
    {
        System.out.println("1. Show all the products in stock");
        System.out.println("2. Ready For Shopping");
        System.out.println("3. End Shopping");
    }

}

