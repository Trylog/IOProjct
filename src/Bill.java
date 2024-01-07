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
		if(product == null || quantity==0) return;
		Product temp;
		int id = product.getProductID();
		for (InternalPosition internalposition : products) {
			temp=internalposition.getProduct();
			int id2=temp.getProductID();
			if(id==id2){
				internalposition.increment(quantity);
				return;
			}
		}
		products.add(new InternalPosition(product,quantity));
	}

	public void printPosition(PrintingPosition product) {
		Product position = product.getProduct();
		int Quantity = product.getQuantity();
		String name = position.getName();

		float price = position.getPrice();
		VATBracket VAT = position.getVAT();
		System.out.println(name+"	"+Quantity+"	"+price+"	"+VAT);
	}

	public void show() {
		for (InternalPosition product:products) {
			Product Product = product.getProduct();
			System.out.println(Product.getName()+"	"+product.getQuantity()+"	"+Product.getPrice()+"	"+Product.getVAT());
		}
	}

	public void removePosition(Product product, int quantity) {
		if(product == null || quantity==0) return;
		Product temp;
		int id = product.getProductID();
		for (InternalPosition internalposition : products) {
			temp=internalposition.getProduct();
			int iquantity = internalposition.getQuantity();
			int id2=temp.getProductID();
			if(id==id2){

				if(quantity>iquantity)return;
				else{
					if(quantity==iquantity){
						products.remove(internalposition);
						return;
					}
					else if(quantity < iquantity){
						internalposition.decrement(-quantity);
						return;
					}
				}
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
			sum += product.getProduct().getPrice() * product.getQuantity();
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
			int index = switch (product.getProduct().getVAT()) {
				case A -> 0;
				case B -> 1;
				case C -> 2;
				case D -> 3;
			};

			taxesSums.set(index, taxesSums.get(index) + product.getProduct().getPrice() * product.getQuantity() * VATBracket.valueOf(product.getProduct().getVAT().name()).value / 100);
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

	public int getQuantity(int id){
			Product product;
			int productID;
			for (InternalPosition x:products) {
				product = x.getProduct();
				productID = product.getProductID();
				if(id==productID){
					return x.getQuantity();
				}
			}

		return 0;
	}
}