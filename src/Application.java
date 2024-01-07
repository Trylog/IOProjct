package sklep;

public class Application {
      private static Bill bill;
       private static int cashierID;
       private int NIP;
       private String CompanyName;
       Application(){ //ustawione dane do przetestowania
         bill = new Bill();
           setCashierId(32);
           bill.addPosition(Database.getProduct(2),2);
           bill.addPosition(Database.getProduct(2),2);
           bill.show();
           bill.calculatingFinalSums();
           System.out.println("\n\n\n");
           bill.addPosition(Database.getProduct(1),2);
           bill.removePosition(Database.getProduct(2),2);
           bill.show();
           bill.calculatingFinalSums();
           System.out.println("\n\n\n");
           Invoice x = new Invoice(bill,277277277,"Firma kox");
           x.printInvoice(cashierID);
       }
       private void setCashierId(int id){
            cashierID = id;
       }
    private int informQuantity(){return 0;}
    private boolean informPayed(){return false;}
    private boolean informInvoice(){return false;}
    private boolean informSending(){return false;}
    private String informEmail(){return null;}
    private void Finalize(){
           bill.calculatingFinalSums();
           boolean payed = informPayed();
           if(payed == false){
               bill=null;
               return;
           }
           else{
               bill.printBill();
               boolean invoice = informInvoice();
               if(invoice == false){
                   Database.saveBill(bill);
                   return;
               }
               else{
                   Invoice newinvoice = new Invoice(bill,NIP,CompanyName);
                   Database.saveInvoice(newinvoice);
                   boolean sending;
                   sending=informSending();
                   if(sending==false){
                        newinvoice.printInvoice(cashierID);
                   }
                   else{
                       String email;
                       email=informEmail();
                       newinvoice.sendInvoice(email);
                   }
               }
               scanned(2);
           }
    }
    private void scanned(int id){
           int quantity;
           quantity = informQuantity();
           if(quantity==0)return;
           Product product=Database.getProduct(id);
           if(product==null)return;
           if(quantity>0)bill.addPosition(product,quantity);
           else if(quantity<0)bill.removePosition(product,quantity);
           int ID = product.getProductID();
           int Quantity = bill.getQuantity(ID);
           PrintingPosition position=new PrintingPosition(product,Quantity );
           bill.printPosition(position);
    }
    public static void main(String[] args){
           new Application();
    }
}

