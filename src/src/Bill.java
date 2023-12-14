package sklep;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Bill {

	private ArrayList<InternalPosition> products;
	private int billId;
	private Date Date;

	Bill(){
		products=new ArrayList<InternalPosition>();
		billId  = (int) new Date().getTime();
		Date = new Date();
	}

	public void printHeader(int cashierID){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	System.out.println("Sklep Fajny");
	System.out.println("NIP 328957834275");
	System.out.println("Kasjer : "+cashierID);
	System.out.println(f.format(Date));

	}
	public void addPosition(Product product, int quantity) {

		for (var produt : products) {

			if(produt.Product.getProductID()==product.getProductID() && produt.Quantity<quantity){
				produt.increment(quantity);
				return;
			}
		}
		products.add(new InternalPosition(product,quantity));
	}

	public void printPosition(PrintingPosition product) {
	System.out.println(product.Product.getName()+"	"+product.Quantity+"	"+product.Product.getPrice()+"	"+product.Product.getVAT());
	}

	public void show() {
		for (InternalPosition product:products) {
			System.out.println(product.Product.getName()+"	"+product.Quantity+"	"+product.Product.getPrice()+"	"+product.Product.getVAT());
		}
	}

	public void removePosition(Product product, int quantity) {
		for (var produt : products) {
			if (produt.Product.getProductID() == product.getProductID()) {
				if(quantity> produt.Quantity) return;
				else {
					if (produt.Quantity > quantity)
						produt.decrement(quantity);
					else {
						products.remove(produt);
					}
				}
				return;
			}
		}
	}

	public void calculatingFinalSums(){
		printSum(sum());;
		printTaxes(taxes());

	}

	private float sum(){
		float sum = 0;
		for (var product : products){
			sum += product.Product.getPrice() * product.Quantity;
		}
		return sum;
	}
	private ArrayList<Float> taxes() {
		ArrayList<Float> taxesSums = new ArrayList<Float>();
		taxesSums.add(0.0f);
		taxesSums.add(0.0f);
		taxesSums.add(0.0f);
		taxesSums.add(0.0f);

		for (var product : products) {
			int index = switch (product.Product.getVAT()) {
				case A -> 0;
				case B -> 1;
				case C -> 2;
				case D -> 3;
			};

			taxesSums.set(index, taxesSums.get(index) + product.Product.getPrice() * product.Quantity * VATBracket.valueOf(product.Product.getVAT().name()).value / 100);
		}

		return taxesSums;
	}

	private void printSum(float sum){
		System.out.println("Suma: "+sum);
	}
	private void printTaxes(ArrayList<Float> taxesSums){
		char v = 'A';
		for(int i=0;i<4;i++){
			System.out.println(v+"	"+taxesSums.get(i));
			v++;
		}

	}

	public void printBill(){
		System.out.println("Dziekujemy za zakupy");
	}

}