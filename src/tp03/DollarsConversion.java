package tp03;

public enum DollarsConversion {
	EURO_LIVRE("€", "£", 0.872813 ), EURO_DOLLAR("€", "$",1.08837), DOLLAR_EURO("$", "€",0.918972), DOLLAR_LIVRE("$", "£",0.801386 ), LIVRE_EURO("£", "€", 1.14572), LIVRE_DOLLAR("£", "$", 1.24784);
	
	private String from;
	private String to;
	private double conv;
	private DollarsConversion(String a, String b, double c) {
		this.from=a;
		this.to=b;
		this.conv=c;
	}
	public String toString() {
		return this.from + "<-->" + this.to;
	}
	public double getConv() {
		return this.conv;
	}
	public String getFrom() {
		return this.from;
	}
	public String getTo() {
		return this.to;
	}
}
