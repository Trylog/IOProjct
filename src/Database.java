package sklep;

import java.util.ArrayList;
public class Database {
    private static ArrayList<InternalPosition> Products;
    static{
        Products=new ArrayList<InternalPosition>();
        Products.add(new InternalPosition(new Product("Chleb pszenny",3.49f, VATBracket.B,1),36));
        Products.add(new InternalPosition(new Product("Mleko muuu",3.99f, VATBracket.B,2),314));
        Products.add(new InternalPosition(new Product("Telewizor 32''",1299.99f, VATBracket.A,3),4));
        Products.add(new InternalPosition(new Product("Radioodbiornik Rydzunio",333.33f, VATBracket.A,4),12));
    }
    private static ArrayList<Bill> bills = new ArrayList<Bill>();
    private static ArrayList<Invoice> invoices= new ArrayList<Invoice>();

    public static Product getProduct(int id){
        Product product;
        int productID;
        for (InternalPosition x:Products) {
            product = x.getProduct();
            productID = product.getProductID();
            if(id==productID){
                return product;
            }
        }
        return null;
    }
    public static void saveBill(Bill bill){
        bills.add(bill);
    }
    public static void saveInvoice(Invoice invoice){
        invoices.add(invoice);
    }
}
