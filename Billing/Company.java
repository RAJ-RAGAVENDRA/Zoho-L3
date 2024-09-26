
public class Company
{
    private String companyName;
    private Product[] stock;

    private Bill[] companyBills;

    Company(String companyName)
    {
        this.companyName = companyName;
        loadStock();
        companyBills = new Bill[1000];
    }


    private void loadStock()
    {
        Product[] products = new Product[]
                {
                        new Product(1,"Rice", 100, 50, "kg"),
                        new Product(2,"Wheat", 100, 42, "kg"),
                        //new Product(3,"GroundNut Oil", 100, 45, "litre"),
                       // new Product(4,"Water Bottle - 1 litre", 100, 50, "nos"),
                        new Product(8,"Kitkat", 100, 10, "nos"),
                        new Product(6,"MilkBikkies", 100, 5, "nos"),
                        //new Product(5,"MarieGold Biscuit", 100, 5, "nos"),
                        new Product(7,"Diary Milk", 100, 5, "nos"),
                       // new Product(9,"Chilly Powder - 20g", 100, 35, "nos"),
                        //new Product(10,"Coconut Oil", 100, 27, "litre"),
                        //new Product(11,"Dish washer", 100, 15, "nos"),
                       // new Product(12,"Dove Soap - 45g", 100, 60, "nos"),
                       // new Product(13,"Meera shampoo - 150 ml", 100, 150, "nos"),
                       // new Product(14,"Colgate paste", 100, 30, "nos"),
                        new Product(15,"Good Night", 100, 55, "nos"),
                        new Product(16,"Lays", 100, 5, "nos"),
                        new Product(17,"Bingo", 100, 10, "nos"),
                        new Product(18,"Chocos", 100, 10, "nos"),
                       // new Product(19,"Garam masala", 100, 30, "nos"),
                       // new Product(20, "Sunflower Oil - 1.5 Litres", 100, 65, "nos")
                };

        this.stock = products;
    }

    public void updateStockQuantity(int productID, double removeCount)
    {
        for (int i = 0; i < stock.length; i++)
        {
            Product product = stock[i];
            if(product.getProductCode() == productID)
            {
                product.setProductQnty( product.getProductQnty() - removeCount);
                return;
            }
        }
    }

    public void displayProductsInCompanyStock()
    {
        System.out.println("Product Name \t\t Stock Available \t\t Price");
        for (int i = 0; i < stock.length; i++)
        {
            Product product = stock[i];
            //if(product.getProductQnty() > 0)
            {
                product.displayCompanyStockProduct();
            }
        }
    }

    public boolean isThisAValidProduct(int productCode)
    {
        for (int i = 0; i < stock.length; i++)
        {
            Product product = stock[i];
            if(product.getProductCode() == productCode)
            {
                return true;
            }
        }
        return false;
    }

    public Product getProductFromCompanyStock(int productCode)
    {
        for (int i = 0; i < stock.length; i++)
        {
            Product product = stock[i];
            if(product.getProductCode() == productCode)
            {
                return product;
            }
        }
        return null;
    }

    public void addBillInCompanyBills(Bill bill)
    {
        int billArrayIndex = bill.getBillID() - 1 ;
        companyBills[billArrayIndex] = bill;
    }

    public void createBill()
    {
        Customer customer = Customer.getCustomerDetails();
        Product[] products= Product.getProductInputsForBill(this);
        double total = 0;
        for (Product product: products)
        {
            double qnty_ordered = product.getProductQnty();
            double productTotal = product.getProductPrice() * product.getProductQnty();
            this.updateStockQuantity(product.getProductCode(), qnty_ordered);
            total = total + productTotal;
        }
        Bill newBill = new Bill(customer, products, total);
        this.addBillInCompanyBills(newBill);
        newBill.displayBill();
    }
}
