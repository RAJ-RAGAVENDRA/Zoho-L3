import java.util.Scanner;

public class Product
{
    public static Scanner getInput = new Scanner(System.in);
    private int productCode;
    private String productName;
    private double productQnty;

    private double productPrice;

    private String unit;

    public Product()
    {

    }
    public Product(int productCode, String productName, double productQnty, double productPrice, String unit)
    {
        this.productCode = productCode;
        this.productName = productName;
        this.productQnty = productQnty;
        this.productPrice = productPrice;
        this.unit = unit;
    }
    public double getProductQnty()
    {
        return productQnty;
    }
    public double getProductPrice()
    {
        return productPrice;
    }
    public int getProductCode() {
        return productCode;
    }
    public void setProductQnty(double productQnty)
    {
        this.productQnty = productQnty;
    }

    public static Product[] getProductInputsForBill(Company myCompany)
    {

        System.out.print("Enter the no of Products you need to buy : ");
        int count = getInput.nextInt();
        UtilMethods.printDottedLineShort();

        Product[] billProducts = new Product[count];
        int code;
        double qnty = 0;
        Product stockProduct = new Product();

        for (int i = 0; i < count; i++)
        {
            boolean qntyAvailableInStock = true;
            boolean isThisAValidProduct = true;
            do
            {
                if(!isThisAValidProduct)
                {
                    System.out.println("check the below details and enter proper Product Code !!!..  ");
                    myCompany.displayProductsInCompanyStock();
                }
                else if (!qntyAvailableInStock)
                {
                    System.out.println("Quantity you entered is not available in our stock. check the below details and enter quantity available in our stock");
                    myCompany.displayProductsInCompanyStock();
                }

                System.out.print("Enter Product code : ");
                code = getInput.nextInt();

                isThisAValidProduct = myCompany.isThisAValidProduct(code);
                if(isThisAValidProduct)
                {
                    System.out.print("Enter Quantity to buy : ");
                    qnty = getInput.nextDouble();
                    UtilMethods.printDottedLineShort();

                    stockProduct = myCompany.getProductFromCompanyStock(code);
                    qntyAvailableInStock = ( stockProduct.productQnty >= qnty);
                }

            }
            while (!isThisAValidProduct || !qntyAvailableInStock);

            Product billProduct = new Product(code, stockProduct.productName, qnty, stockProduct.productPrice, stockProduct.unit);
            billProducts[i] = billProduct;
            myCompany.updateStockQuantity(code, qnty);
        }
        return billProducts;
    }

    public void displayCompanyStockProduct()
    {
        UtilMethods.printDottedLineShort();
        System.out.println(productCode + "\t\t" + productName + "\t\t\t\t" + productQnty + " " + unit + "\t\t" + productPrice + "per " + unit);
    }

    public void displayBillProduct()
    {
        UtilMethods.printDottedLineShort();
        System.out.println(productName + "\t\t\t\t" + productQnty + "\t\t" + productPrice + "\t\t" + (productQnty * productPrice));
    }

}
