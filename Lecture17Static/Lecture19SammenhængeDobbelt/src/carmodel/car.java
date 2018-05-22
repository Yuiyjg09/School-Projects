package carmodel;

import java.util.*;

public class car {
	private String license;
	private double pricePerDay;
	private int purchaseYear;
	private ArrayList<rental> rentals;
	
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
	
	public void addRental(rental r) {
		rentals.add(r);
		r.addCar(this);
	}
	
	public void removeRental(rental r) {
		rentals.remove(r);
		r.removeCar(this);
	}
	
	public ArrayList<rental> getRentals() {
		return new ArrayList<rental>(rentals);
	}
	
	public int getLongestRental() {
		int longestRental = 0;
		for (rental r : rentals) {
			if(r.getDays() >= longestRental) {
				longestRental = r.getDays();
			}
		}
		
		return longestRental;
	}
}
