package sklep;

public class Product {
	private String Name;
	private float Price;
	private VATBracket VAT;
	private int ProductID;

	Product(String Name, float Price, VATBracket VAT, int ProductID){
		this.Name=Name;
		this.Price=Price;
		this.VAT=VAT;
		this.ProductID=ProductID;
	}

	public String getName() {
		return Name;
	}

	public float getPrice() {
		return Price;
	}

	public VATBracket getVAT() {
		return VAT;
	}

	public int getProductID() {
		return ProductID;
	}
}