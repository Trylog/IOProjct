package sklep;

import sklep.Bill;

public class Invoice{
    Bill Bill;
    int NIP;
    String CompanyName;

    public Invoice(Bill Bill,int NIP,String CompanyName){
        this.Bill=Bill;
        this.NIP = NIP;
        this.CompanyName = CompanyName;

    }

    public void printInvoice(int cashierID){
        Bill.printHeader(cashierID);
        System.out.println("NAZWA FIRMY : " + CompanyName);
        System.out.println("NIP : " + NIP);
        Bill.show();
        Bill.calculatingFinalSums();
    }
    public void sendInvoice(String email){
        System.out.println("Wysylanie faktury na adres email: " + email);
    }

}

