package sklep;

public class PrintingPosition {

	private Product Product;
	private int Quantity;

	public PrintingPosition(Product product, int quantity) {

		Product=product;
		Quantity=quantity;
	}
	public Product getProduct(){
		return Product;
	}
	public int getQuantity(){
		return Quantity;
	}
	public void setQuantity(int quantity){
		Quantity=quantity;
	}
}