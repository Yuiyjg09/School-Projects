package carmodel;

public class car {
	private String license;
	private double pricePerDay;
	private int purchaseYear;
	
	public car(String license, double pricePerDay, int purchaseYear) {
		this.license = license;
		this.pricePerDay = pricePerDay;
		this.purchaseYear = purchaseYear;
	}
	
	public String getLicense() {
		return license;
	}
	
	public double getPricePerDay() {
		return pricePerDay;
	}
	
	public void setLicense(String license) {
		this.license = license;
	}
	
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public int getPurchaseYear() {
		return purchaseYear;
	}
}
