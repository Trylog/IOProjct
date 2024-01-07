package sklep;

public enum VATBracket {
	A(23),
	B(8),
	C(5),
	D(0);

	public final int value;
	private VATBracket(int label) {this.value = label;}
}

