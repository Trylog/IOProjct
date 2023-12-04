import java.util.ArrayList;

public class Bill {

	private InternalPosition[] products;
	private int billId;
	private int Date;

	/**
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addPosition(Product product, int quantity) {
		// TODO - implement Bill.addPosition
		for (var produt : products) {
			products[1] = new InternalPosition(product, quantity);
		}
	}

	/**
	 * 
	 * @param product
	 */
	private void printPosition(PrintingPosition product) {
		// TODO - implement Bill.printPosition
		throw new UnsupportedOperationException();
	}

	public InternalPosition[] show() {
		// TODO - implement Bill.show
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param product
	 * @param quantity
	 */
	public void removePosition(Product product, int quantity) {
		// TODO - implement Bill.removePosition
		throw new UnsupportedOperationException();
	}

	public void calculatingFinalSums(){


	}

	private float calcSum(){
		float sum = 0;
		for (var product : products){
			sum += product.Product.getPrice() * product.Quantity;
		}
		printSum();
		return sum;
	}
	private ArrayList<Float> calcTaxes(){
		var taxesSums = new ArrayList<Float>();
		taxesSums.add(0.0f);
		taxesSums.add(0.0f);
		taxesSums.add(0.0f);
		for (var product : products){
			switch (product.Product.getVAT()) {
				case A -> taxesSums.add(0, taxesSums.get(0) + product.Product.getPrice() * product.Quantity
						* product.Product.getVAT().value);
				case B -> taxesSums.add(1, taxesSums.get(1) + product.Product.getPrice() * product.Quantity
						* product.Product.getVAT().value);
				case C -> taxesSums.add(2, taxesSums.get(2) + product.Product.getPrice() * product.Quantity
						* product.Product.getVAT().value);
			}
		}
		return taxesSums;
	}
	private void printSum(){
		System.out.println("test");
	}
	private void printTaxes(){

	}

}