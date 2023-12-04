public enum VATBracket {
	A(0.23f),
	B(0.08f),
	C(0.05f),
	D(0.0f);

	public final float value;

	private VATBracket(float label) {
		this.value = label;
	}
}