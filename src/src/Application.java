package sklep;

public class Application {
      private static Bill bill;
       private static int cashierID;
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
    public static void main(String[] args){
           new Application();
    }

}

