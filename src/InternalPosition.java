package sklep;

import sklep.PrintingPosition;

public class InternalPosition extends PrintingPosition {

	public InternalPosition(Product product, int quantity) {
		super(product, quantity);
	}

	public void increment(int quantity) {
		this.setQuantity(this.getQuantity()+quantity);
	}
	public void decrement(int quantity) {
		this.setQuantity(this.getQuantity()-quantity);
	}
}