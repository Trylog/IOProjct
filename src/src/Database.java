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
    private ArrayList<Bill> bills = new ArrayList<Bill>();
    private ArrayList<Invoice> invoices= new ArrayList<Invoice>();
    private String Login = "login";
    private String Passowrd = "password";
    public static Product getProduct(int id){
        Product product;
        for (InternalPosition x:Products) {
            if(x.Product.getProductID()==id){
                product=x.Product;
                return product;
            }
        }
        return null;
    }
    public void saveBill(Bill bill){
        bills.add(bill);
    }
    public void saveInvoice(Invoice invoice){
        invoices.add(invoice);
    }

    public boolean login(String login, String password){
        if(login.compareTo(Login) == 0 && password.compareTo(Passowrd)==0)
        return true;
        return false;
    }

}
